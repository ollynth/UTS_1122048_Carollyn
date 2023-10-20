package Model;

public class Comment {
    private String commenTid;
    private String text;
    private ContentState status;
    
    public Comment(String commenTid, String text, ContentState status) {
        this.commenTid = commenTid;
        this.text = text;
        this.status = status;
    }
    public String getCommenTid() {
        return commenTid;
    }
    public void setCommenTid(String commenTid) {
        this.commenTid = commenTid;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public ContentState getStatus() {
        return status;
    }
    public void setStatus(ContentState status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Comment ID :  " + commenTid + ", text=" + text + ", status=" + status + "\n";
    }
}
