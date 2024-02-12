package aa.bb.corrtpapigetposts;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyViewHolder
extends RecyclerView.ViewHolder {


    public TextView txtTitle;
    public TextView txtBody;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle =itemView.findViewById(R.id.txtTitle);
        txtBody =itemView.findViewById(R.id.txtBody);

    }
}
