package aa.bb.corrtpapigetposts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RechercherActivity extends AppCompatActivity {
Button btnRechercher;
EditText editRechercher;
TextView txtTitle, txtBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher);
        editRechercher=findViewById(R.id.editRechercher);
        txtTitle=findViewById(R.id.txtTitle);
        txtBody=findViewById(R.id.txtBody);
        btnRechercher=findViewById(R.id.btnRechercher);
        btnRechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url="https://jsonplaceholder.typicode.com/posts/" + editRechercher.getText().toString();
                JsonObjectRequest maRequette = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    txtTitle.setText(response.getString("title"));
                                    txtBody.setText(response.getString("body"));

                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //code en cas d'eereur
                                txtTitle.setText("erreur");
                                txtBody.setText(error.getMessage());
                            }
                        }

                );
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(maRequette);
            }
        });



    }
}