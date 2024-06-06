package com.example.project;
import java.io.File;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostTest {

    private final String postFilePath = "TXT_FILES/post.txt";
    private final String commentFilePath = "TXT_FILES/comment.txt";

    @BeforeEach
    public void setUp() {
        // Clean up files before each test
        new File(postFilePath).delete();
        new File(commentFilePath).delete();
    }

    @AfterEach
    public void tearDown() {
        // Clean up files after each test
        new File(postFilePath).delete();
        new File(commentFilePath).delete();
    }


    @Test
    public void testAddPostInvalidTitle() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(1, "2-LOREM", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet.", tags, "Difficult", "Highly Needed");
        boolean result = post.addPost();
        assertFalse(result, "Post with invalid title should not be added"+ "\n");
    }

    @Test
    public void testAddPostValidTitle() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(1, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Maecenas accumsan lacus vel facilisis volutpat est velit egestas dui. In fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Eget velit aliquet sagittis id. Vitae et leo duis ut diam quam.", tags, "Difficult", "Highly Needed");
        boolean result = post.addPost();
        assertTrue(result, "Post with a valid title should be added"+ "\n");
    }

    @Test
    public void testAddPostInvalidTags() {
        String[] tags = {"JAVA", "Lorem", "Ipsum"};
        Post post = new Post(2, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Maecenas accumsan lacus vel facilisis volutpat est velit egestas dui. In fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Eget velit aliquet sagittis id. Vitae et leo duis ut diam quam.", tags, "Difficult", "Highly Needed");
        boolean result = post.addPost();
        assertFalse(result, "Post with invalid tags should not be added"+ "\n");
    }

    @Test
    public void testAddPostValidTags() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(2, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Maecenas accumsan lacus vel facilisis volutpat est velit egestas dui. In fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Eget velit aliquet sagittis id. Vitae et leo duis ut diam quam.", tags, "Difficult", "Highly Needed");
        boolean result = post.addPost();
        assertTrue(result, "Post with valid tags should be added"+ "\n");
    }

    
    @Test
    public void testAddPostInvalidBody() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(3, "Lorem Ipsum", "Short body", tags, "Difficult", "Highly Needed");
        boolean result = post.addPost();
        assertFalse(result, "Post with invalid body should not be added"+ "\n");
    }

    @Test
    public void testAddPostValidBody() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(3, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Maecenas accumsan lacus vel facilisis volutpat est velit egestas dui. In fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Eget velit aliquet sagittis id. Vitae et leo duis ut diam quam.", tags, "Easy", "Ordinary");
        boolean result = post.addPost();
        assertTrue(result, "Post with valid body should be added"+ "\n");
    }


    @Test
    public void testAddPostInvalidTypeEmergency() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(4, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet. It is based on several concepts including encapsulation, inheritance, and polymorphism. ", tags, "Easy", "Immediately Needed");
        boolean result = post.addPost();
        assertFalse(result, "Post with invalid type/emergency combination should not be added"+ "\n");
    }

    @Test
    public void testAddPostValidTypeEmergency() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(4, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet. It is based on several concepts including encapsulation, inheritance, and polymorphism. ", tags, "Difficult", "Immediately Needed");
        boolean result = post.addPost();
        assertTrue(result, "Post with valid type/emergency combination should be added"+ "\n");
    }


    @Test
    public void testAddPostInvalidTitle2() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(5, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet nisl purus in mollis nunc sed id. Accumsan tortor posuere ac ut consequat. Convallis convallis tellus id interdum velit laoreet id. Morbi tristique senectus et netus et. Interdum consectetur libero id faucibus nisl tincidunt eget nullam non.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet.", tags, "Difficult", "Highly Needed");
        boolean result = post.addPost();
        assertFalse(result, "Post with invalid title should not be added"+ "\n");
    }

    @Test
    public void testAddPostValidTitle2() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(5, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Maecenas accumsan lacus vel facilisis volutpat est velit egestas dui. In fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Eget velit aliquet sagittis id. Vitae et leo duis ut diam quam.", tags, "Difficult", "Highly Needed");
        boolean result = post.addPost();
        assertTrue(result, "Post with a valid title should be added"+ "\n");
    }


    @Test
    public void ValidPostBodyPostDifficulty() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(6, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Maecenas accumsan lacus vel facilisis volutpat est velit egestas dui. In fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Eget velit aliquet sagittis id. Vitae et leo duis ut diam quam.", tags, "Difficult", "Highly Needed");
        boolean result = post.addPost();
        assertTrue(result, "Post with valid title should be added"+ "\n");
    }

    @Test
    public void InvalidPostBodyPostDifficulty() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(6, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet.", tags, "Difficult", "Highly Needed");
        boolean result = post.addPost();
        assertFalse(result, "Post with invalid title should not be added"+ "\n");
    }





    @Test
    public void testAddCommentInvalidLengthShort() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(7, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet.", tags, "Difficult", "Highly Needed");
        post.addPost();

        boolean result = post.addComment("Hello");
        assertFalse(result, "Comment too short should not be added"+ "\n");
    }

    @Test
    public void testAddCommentValidLength() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(9, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet.", tags, "Difficult", "Highly Needed");
        post.addPost();

        boolean result = post.addComment("This is a valid comment");
        assertTrue(result, "Comment should be added"+ "\n");
    }


    @Test
    public void testAddCommentInvalidLengthLong() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(9, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet.", tags, "Difficult", "Highly Needed");
        post.addPost();

        boolean result = post.addComment("This is an invalid comment, because it has too many words");
        assertFalse(result, "Comment should not be added"+ "\n");
    }
    
    @Test
    public void testAddCommentInvalidNumberOfComments() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(10, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet.", tags, "Difficult", "Highly Needed");
        post.addPost();
        post.addComment("This is the first comment.");
        post.addComment("This is the second comment.");
        post.addComment("This is the third comment.");
        post.addComment("This is the fourth comment.");
        post.addComment("This is the fifth comment.");

        boolean result = post.addComment("Sixth comment added to difficult post.");
        assertFalse(result, "Should not add more than 5 comments for non-easy posts"+ "\n");
    }

    @Test
    public void testAddCommentInvalidNumberOfComments2() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(11, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet.", tags, "Easy", "Ordinary");
        post.addPost();
        post.addComment("This is the first comment.");
        post.addComment("This is the second comment.");
        post.addComment("This is the third comment.");

        boolean result = post.addComment("Fourth comment added to an easy difficulty post");
        assertFalse(result, "Should not add more than 3 comments for non-easy posts"+ "\n");
    }

    @Test
    public void testAddCommentInvalidLowercase() {
        String[] tags = {"java", "lorem", "ipsum"};
        Post post = new Post(12, "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet purus gravida quis blandit. Purus sit amet luctus venenatis lectus magna fringilla. Cursus risus at ultrices mi tempus imperdiet.", tags, "Easy", "Ordinary");
        post.addPost();
        
        boolean result = post.addComment("this sentence is only lowercase");
        assertFalse(result, "The comment should not be added as the first letter is not Uppercase"+ "\n");
    }
}
