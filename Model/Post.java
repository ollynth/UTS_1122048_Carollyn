package Model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Post {
    private String postID;
    private ContentState status;
    private ContentType postType;
    private Timestamp timeUpload;
    private ArrayList<Comment> comments;
    
    public Post(String postID, ContentState status, ContentType postType, Timestamp timeUpload,
            ArrayList<Comment> comments) {
        this.postID = postID;
        this.status = status;
        this.postType = postType;
        this.timeUpload = timeUpload;
        this.comments = comments;
    }
    public String getPostID() {
        return postID;
    }
    public void setPostID(String postID) {
        this.postID = postID;
    }
    public ContentState getStatus() {
        return status;
    }
    public void setStatus(ContentState status) {
        this.status = status;
    }
    public ContentType getPostType() {
        return postType;
    }
    public void setPostType(ContentType postType) {
        this.postType = postType;
    }
    public Timestamp getTimeUpload() {
        return timeUpload;
    }
    public void setTimeUpload(Timestamp timeUpload) {
        this.timeUpload = timeUpload;
    }
    public ArrayList<Comment> getComments() {
        return comments;
    }
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post [postID=" + postID + ", status=" + status + ", postType=" + postType + ", timeUpload=" + timeUpload
                + ", comments=" + comments + "\n";
    }
}
