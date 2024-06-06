package com.example.project;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String postType;
    private String postEmergency;
    private int commentID;

    private ArrayList<String> postComments = new ArrayList<>();

    private static final String[] VALID_TYPES = {"Very Difficult", "Difficult", "Easy"};
    private static final String[] VALID_EMERGENCIES = {"Immediately Needed", "Highly Needed", "Ordinary"};

    public Post(int postID, String postTitle, String postBody, String[] postTags, String postType, String postEmergency) {
        this.postID = postID;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postTags = postTags;
        this.postType = postType;
        this.postEmergency = postEmergency;
    }

    public boolean addPost() {
        // if (!validatePostTitle() || !validatePostBody() || !validatePostTags() || !validatePostTypeAndEmergency()) {
        //     System.out.println("Validation failed: Invalid post.");
        //     return false;
        // }

        if (!validatePostTitle()) {
            System.out.println("Validation failed: Invalid post title." + "\n");
            return false;
        }
        if (!validatePostBody()) {
            System.out.println("Validation failed: Invalid post body."+ "\n");
            return false;
        }
        if (!validatePostTags()) {
            System.out.println("Validation failed: Invalid post tags."+ "\n");
            return false;
        }
        if (!validatePostTypeAndEmergency()) {
            System.out.println("Validation failed: Invalid post type or emergency."+ "\n");
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("post.txt", true))) {
            writer.write(toString());
            writer.newLine();
            System.out.println("Post ID: " + this.postID + " - Post added successfully.");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean validatePostTitle() {
        if (postTitle.length() < 10 || postTitle.length() > 250) {
            System.out.println("Post title length validation failed.");
            return false;
        }
        String firstFive = postTitle.substring(0, 5);
        if (firstFive.matches("[^a-zA-Z].*")) {
            System.out.println("Post title first five characters validation failed.");
            return false;
        }
        return true;
    }

    private boolean validatePostBody() {
        if (postType.equals("Very Difficult") || postType.equals("Difficult")) {
            if (postBody.length() < 300) {
                System.out.println("Post body length validation failed for 'Very Difficult' or 'Difficult'.");
                return false;
            }
        } else {
            if (postBody.length() < 250) {
                System.out.println("Post body length validation failed for Easy difficulty.");
                return false;
            }
        }
        return true;
    }

    private boolean validatePostTags() {
        if (postTags.length < 2 || postTags.length > 5) {
            System.out.println("Post tags count validation failed.");
            return false;
        }
        for (String tag : postTags) {
            if (!tag.equals(tag.toLowerCase()) || tag.length() < 2 || tag.length() > 10) {
                System.out.println("Post tag validation failed for tag: " + tag);
                return false;
            }
            
        }
        if (postType.equals("Easy") && postTags.length > 3) {
            System.out.println("Post tags count validation failed for 'Easy': Too many tags!!.");
            return false;
        }
        return true;
    }

    

    private boolean validatePostTypeAndEmergency() {
        if (!Arrays.asList(VALID_TYPES).contains(postType) || !Arrays.asList(VALID_EMERGENCIES).contains(postEmergency)) {
            System.out.println("Post type or emergency validation failed.");
            return false;
        }
        if (postType.equals("Easy") && (postEmergency.equals("Immediately Needed") || postEmergency.equals("Highly Needed"))) {
            System.out.println("'Easy' post cannot have 'Immediately Needed' or 'Highly Needed' status.");
            return false;
        }
        if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postEmergency.equals("Ordinary")) {
            System.out.println("'Very Difficult' or 'Difficult' post cannot have 'Ordinary' status.");
            return false;
        }
        return true;
    }

    public boolean addComment(String comment) {
        if (!validateComment(comment)) {
            return false;
        }

        // if (!postExists(this.postID)) {
        //     System.out.println("Post ID does not exist.");
        //     // System.out.println(this.postID);
        //     return false;
        // }


        postComments.add(comment);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("comment.txt", true))) {
            writer.write("Post ID: " + this.postID + " - Comment: " + comment);
            writer.newLine();
            System.out.println("Post ID: " + this.postID + " - New comment created successfully");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean validateComment(String comment) {
        String[] words = comment.split(" ");
        if (words.length < 4 || words.length > 10) {
            System.out.println("Comment word count validation failed.");
            return false;
        }
        if (!Character.isUpperCase(words[0].charAt(0))) {
            System.out.println("Comment first word uppercase validation failed.");
            return false;
        }
        if (postComments.size() >= 5 || (postType.equals("Easy") && postComments.size() >= 3) || (postEmergency.equals("Ordinary") && postComments.size() >= 3)) {
            System.out.println("Too many comments - validation failed.");
            return false;
        }
        return true;
    }


    // private boolean postExists(int postID) {
    //     try (BufferedReader reader = new BufferedReader(new FileReader("post.txt"))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             if (line.contains("Post ID: " + postID)) {
    //                 return true;
    //             }
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }
    

    @Override
    public String toString() {
        return "Post ID: " + postID + ", Title: " + postTitle + ", Body: " + postBody + ", Tags: " 
        + String.join(", ", postTags) + ", Type: " + postType + ", Emergency: " + postEmergency;
    }
}
