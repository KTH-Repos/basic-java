import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  Tomas
 * @version 2020-11-13
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
    /**
     * Test that a comment is properly created
     */
    @Test
    public void addComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
        assertEquals(true, salesIte1.addComment("Fred", "Great - I perform brain surgery every week now!", 4));
    }

    /**
     * Test that two comments from the same author is not created.
     */
    @Test
    public void testAddCommentFromTheSameAuthor()
    {
        SalesItem salesIte1 = new SalesItem("teapot", 50);
        assertEquals(true, salesIte1.addComment("Tomas", "Its a nice product", 4));
        assertEquals(false, salesIte1.addComment("Tomas", "Not so good", 2));
    }

    /**
     * Test that ratings are between 1 and 5.
     */
    @Test
    public void testOutOfBoundRating()
    {
        SalesItem salesIte1 = new SalesItem("teapot", 50);
        assertEquals(false, salesIte1.addComment("Tomas", "Its worth every penny", 6));
        assertEquals(false, salesIte1.addComment("Erik", "Its garbage", 0));
    }

    

    

    @Test
    public void testStorageOfAuthorAndRating()
    {
        SalesItem salesIte2 = new SalesItem("teabag", 50);
        assertEquals(true, salesIte2.addComment("tomas", "great product", 5));
        salesIte2.showInfo();
    }
}














