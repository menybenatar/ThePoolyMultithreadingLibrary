package il.ac.hit.pooly.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTaskTest {

    private ExampleTask task;

    /**
     * Sets up the ExampleTask object before each test case.
     *
     * @throws Exception if an exception occurs during setup
     */
    @Before
    public void setUp() throws Exception {
        //create new ExampleTask for testing
        task = new ExampleTask("task 1", 10);
    }

    /**
     * Cleans up the ExampleTask object after each test case.
     *
     * @throws Exception if an exception occurs during cleanup
     */
    @After
    public void tearDown() throws Exception {
        task = null;
    }

    /**
     * Test case for setPriority() method.
     */
    @Test
    public void setPriority() {
        int expected = 10;
        task.setPriority(expected);
        int actual = task.getPriority();
        assertEquals(expected, actual, 0.02);
    }

    /**
     * Test case for getPriority() method.
     */
    @Test
    public void getPriority() {
        int expected = 10;
        int actual = task.getPriority();
        assertEquals(expected, actual, 0.02);
    }

    /**
     * Test case for perform() method.
     */
    @Test
    public void perform() {
        int expected = 2000;
        long start = System.currentTimeMillis();
        task.perform();
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        assertEquals(expected, elapsedTime, 1500);
    }
}