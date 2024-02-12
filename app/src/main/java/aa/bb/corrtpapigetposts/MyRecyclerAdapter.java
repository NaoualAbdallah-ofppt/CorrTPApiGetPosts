package aa.bb.corrtpapigetposts;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter
extends RecyclerView.Adapter<MyViewHolder> {
    public MyRecyclerAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent  ,false);
        return new MyViewHolder(V);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i("xx", String.valueOf(position));
        holder.txtTitle.setText(Post.lstPosts.get(position).title + "("+String.valueOf(Post.lstPosts.get(position).id)+")");
        holder.txtBody.setText(Post.lstPosts.get(position).body);

    }

    @Override
    public int getItemCount() {
        return Post.lstPosts.size();
    }


}

