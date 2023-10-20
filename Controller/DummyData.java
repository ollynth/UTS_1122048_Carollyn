package Controller;
import java.sql.Timestamp;
import java.util.ArrayList;

import Model.*;

public class DummyData {
    ArrayList<User> user = new ArrayList<>();
    ArrayList<Post> posts = new ArrayList<>();
    DummyData () {
        //comment user 1
        Comment comment1 = new Comment("1", "This is a comment.", ContentState.SHOWED);
        Comment comment2 = new Comment("2", "Another comment.", ContentState.SHOWED);
        Comment comment3 = new Comment("3", "Yet another comment.", ContentState.SHOWED);
        ArrayList<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        // Create a Post
        Timestamp postTimestamp = new Timestamp(System.currentTimeMillis());
        Post post = new Post("1001", ContentState.PINNED, ContentType.PICTURE, postTimestamp, comments);

        // Create a Reel
        Reel reel = new Reel("2001", ContentState.SHOWED, ContentType.VIDEO, postTimestamp, comments, 60, 10000);

        // Create a Story
        Story story = new Story("3001", ContentState.ARCHIVED, ContentType.PICTURE, postTimestamp, comments, 15, 5000);

        // post user 1
        ArrayList<Post> userPosts = new ArrayList<>();
        userPosts.add(post);
        userPosts.add(reel);
        userPosts.add(story);

        //comment user 2
        Comment comment4 = new Comment("4", "I like this post!", ContentState.SHOWED);
        Comment comment5 = new Comment("5", "Great content!", ContentState.SHOWED);

        ArrayList<Comment> comments2 = new ArrayList<>();
        comments2.add(comment4);
        comments2.add(comment5);

        // Create a Post
        Timestamp postTimestamp2 = new Timestamp(System.currentTimeMillis());
        Post post2 = new Post("1002", ContentState.SHOWED, ContentType.VIDEO, postTimestamp2, comments2);

        // Create a Reel
        Reel reel2 = new Reel("2002", ContentState.SHOWED, ContentType.VIDEO, postTimestamp2, comments2, 45, 7500);

        // Create a Story
        Story story2 = new Story("3002", ContentState.SHOWED, ContentType.PICTURE, postTimestamp2, comments2, 20, 3000);

        // Create a User with some posts
        ArrayList<Post> userPosts2 = new ArrayList<>();
        userPosts2.add(post2);
        userPosts2.add(reel2);
        userPosts2.add(story2);

        user.add(new User("u123", "andrean", "password123", "bla bla bla", userPosts));
        user.add(new User("u456", "seana", "password456", "said nvm", userPosts2));
        posts.add(post);
        posts.add(post2);
        posts.add(reel);
        posts.add(reel2);
        posts.add(story);
        posts.add(story2);
    }
}