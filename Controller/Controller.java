package Controller;
import Model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private DummyData dummy =  new DummyData();

    //menu 1
    public void showUserPosts(String inpIDUser) {
        User targetUser = null;
        for (User user : dummy.user) {
            if (user.getUserID().equals(inpIDUser)) {
                targetUser = user;
                break;
            }
        }
        if (targetUser != null) {
            ArrayList<Post> targetUserPosts = targetUser.getPosts();
            // buat daftar post berdasarkan bulan upload
            Map<Integer, List<Post>> postsByMonth = new HashMap<>();
            for (Post post : targetUserPosts) {
                int month = post.getTimeUpload().toLocalDateTime().getMonthValue();
                postsByMonth.computeIfAbsent(month, k -> new ArrayList<>()).add(post);
            }
            // Sort posts by status (SHOWED, ARCHIVED, DELETED)
            List<Post> displayedPosts = new ArrayList<>();
            List<Post> archivedPosts = new ArrayList<>();
            List<Post> deletedPosts = new ArrayList<>();

            for (List<Post> postsInMonth : postsByMonth.values()) {
                for (Post postss : postsInMonth) {
                    switch (postss.getStatus()) {
                        case SHOWED:
                            displayedPosts.add(postss);
                            break;
                        case ARCHIVED:
                            archivedPosts.add(postss);
                            break;
                        case DELETED:
                            deletedPosts.add(postss);
                            break;
                    }
                }
            }
            // PINNED posts
                System.out.println("PINNED Posts :");
                for (Post pst : targetUserPosts) {
                    int count = 0;
                    if (pst.getStatus() == ContentState.PINNED) {
                        System.out.println(pst);
                        count++;

                        if (count == 3) {
                            break;
                        }
                    }
                }

            // SHOWED posts
                System.out.println("SHOWED Posts:");
                for (Post pst : displayedPosts) {
                    System.out.println(pst);
                }

            // Display ARCHIVED posts
                System.out.println("ARCHIVED Posts:");
                for (Post pst : archivedPosts) {
                    System.out.println(pst);
                }

            // Display DELETED posts
                System.out.println("DELETED Posts:");
                System.out.println("Total DELETED Posts: " + deletedPosts.size());
        
        } else {
            System.out.println("User with userID " + inpIDUser + " not found.");
        }
    }

    //menu 2
    public void showPost (String inpID) {
        Post targetPost = null;
        for (Post pst : dummy.posts) {
            if (pst.getPostID().equals(inpID)) {
                targetPost = pst;
                break;
            }
        }

        if (targetPost != null) {
            System.out.println(targetPost);
        } else {
            System.out.println("Post with ID " + inpID + " not found.");
        }
    }

    // menu 3
    private boolean canChangePostState(ContentState currentStatus, ContentState newStatus) {
        if (currentStatus == ContentState.SHOWED) {
            return newStatus == ContentState.ARCHIVED || newStatus == ContentState.PINNED;
        } else if (currentStatus == ContentState.ARCHIVED) {
            return newStatus == ContentState.DELETED;
        } else if (currentStatus == ContentState.PINNED) {
            return newStatus == ContentState.SHOWED;
        } else {
            return false;
        }
    }

    public void changePostState(String inpIDUser, String postID, ContentState newStatus) {
        User targetUser = null;
        for (User user : dummy.user) {
            if (user.getUserID().equals(inpIDUser)) {
                targetUser = user;
                break;
            }
        }
        ArrayList<Post> userPosts = targetUser.getPosts();

        // cari post berdasarkan id post
        Post targetPost = null;
        for (Post post : userPosts) {
            if (post.getPostID().equals(postID)) {
                targetPost = post;
                break;
            }
        }
        if (targetPost != null) {
            ContentState currentStatus = targetPost.getStatus();

            if (canChangePostState(currentStatus, newStatus)) {
                // ganti status post
                targetPost.setStatus(newStatus);
                System.out.println("Post " + postID + " state changed to " + newStatus);
            } else {
                System.out.println("Invalid state change. Check the rules.");
            }
        } else {
            System.out.println("Post with ID " + postID + " not found.");
        }
    }

    // menu 4
    public void showBestPost(String inpIDUser) {
        User targetUser = null;
        for (User user : dummy.user) {
            if (user.getUserID().equals(inpIDUser)) {
                targetUser = user;
                break;
            }
        }
        ArrayList<Post> userPosts = targetUser.getPosts();

        Post bestPicturePost = findBestPost(userPosts, ContentType.PICTURE);
        Post bestVideoPost = findBestPost(userPosts, ContentType.VIDEO);

        // Display the best posts of each type
        if (bestPicturePost != null) {
            System.out.println("Best Picture Post: " + bestPicturePost);
        }

        if (bestVideoPost != null) {
            System.out.println("Best Video Post: " + bestVideoPost);
        }

    }

    private Post findBestPost(ArrayList<Post> userPosts, ContentType postType) {
        // Filter posts of the specified type
        ArrayList<Post> filteredPosts = new ArrayList<>();
        for (Post post : userPosts) {
            if (post.getPostType()== postType) {
                filteredPosts.add(post);
            }
        }
        if (filteredPosts.isEmpty()) {
            return null;
        }
        filteredPosts.sort((post1, post2) -> {
            int comparison = 0;

            if (postType == ContentType.VIDEO) {
                comparison = Integer.compare(((Reel) post2).getPlayedCount(), ((Reel) post1).getPlayedCount());
            } else if (postType == ContentType.PICTURE) {
                comparison = Integer.compare(((Story) post2).getViews(), ((Story) post1).getViews());
            }

            if (comparison == 0) {
                comparison = post2.getTimeUpload().compareTo(post1.getTimeUpload());
            }

            return comparison;
        });

        return filteredPosts.get(0);
    }
}