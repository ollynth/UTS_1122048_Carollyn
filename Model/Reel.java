package Model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Reel extends Post {
    private int duration;
    private int playedCount;

    public Reel(String postID, ContentState status, ContentType postType, Timestamp timeUpload,
            ArrayList<Comment> comments, int duration, int playedCount) {
        super(postID, status, postType, timeUpload, comments);
        this.duration = duration;
        this.playedCount = playedCount;
    }

    public int getDuration() {
        return duration;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }


    public int getPlayedCount() {
        return playedCount;
    }


    public void setPlayedCount(int playedCount) {
        this.playedCount = playedCount;
    }

    @Override
    public String toString() {
        return super.toString() +  "\nReel [duration=" + duration + ", playedCount=" + playedCount + "]";
    }
    
}
