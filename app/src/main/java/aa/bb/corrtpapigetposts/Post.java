package aa.bb.corrtpapigetposts;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Post {
    int id;
    String title;
    String body;
    public static ArrayList<Post> lstPosts =new ArrayList<>();

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public Post(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }


}
