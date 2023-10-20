package Model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Feed extends Post{
    private String caption;
    private int likes;
    
    public Feed(String postID, ContentState status, ContentType postType, Timestamp timeUpload,
            ArrayList<Comment> comments, String caption, int likes) {
        super(postID, status, postType, timeUpload, comments);
        this.caption = caption;
        this.likes = likes;
    }
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }   

    @Override
    public String toString() {
        return super.toString() + "\nFeed [caption=" + caption + ", likes=" + likes + "]";
    }
}