package Model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Story extends Post {
    private int duration;
    private int views;


    public Story(String postID, ContentState status, ContentType postType, Timestamp timeUpload,
            ArrayList<Comment> comments, int duration, int views) {
        super(postID, status, postType, timeUpload, comments);
        this.duration = duration;
        this.views = views;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    
    @Override
    public String toString() {
        return super.toString() + "Story [duration=" + duration + ", views=" + views + "]";
    }
}