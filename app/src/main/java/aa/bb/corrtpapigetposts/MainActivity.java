package aa.bb.corrtpapigetposts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url="https://jsonplaceholder.typicode.com/posts";
        JsonArrayRequest maRequette = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
for (int i=0;i<response.length();i++)
{
Log.i("xx",String.valueOf(i));

    try {
        JSONObject jo = response.getJSONObject(i);
        Post P = new Post(jo.getInt("id"), jo.getString("title"),jo.getString("body"));
        Post.lstPosts.add(P);




    } catch (JSONException e) {
        throw new RuntimeException(e);
    }


}
                        MyRecyclerAdapter A = new MyRecyclerAdapter();
                        //si scrol vertical
                        LinearLayoutManager LLM = new LinearLayoutManager(MainActivity.this);
                        //LinearLayoutManager LLM = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                        RecyclerView RV=findViewById(R.id.RV);
                        RV.setLayoutManager(LLM);
                        RV.setAdapter(A);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Erreur : " +error.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                }


        );

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(maRequette);

    }
}