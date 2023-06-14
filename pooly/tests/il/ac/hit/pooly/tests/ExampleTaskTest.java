package il.ac.hit.pooly.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.Duration;
import java.time.Instant;
import static org.junit.Assert.*;

public class ExampleTaskTest {

    private ExampleTask task;
    @Before
    public void setUp() throws Exception {
        task = new ExampleTask("task 1", 10);
    }

    @After
    public void tearDown() throws Exception {
        task = null;
    }

    @Test
    public void setPriority() {
        int expected = 10;
        task.setPriority(expected);
        int actual = task.getPriority();
        assertEquals(expected, actual, 0.02);
    }

    @Test
    public void getPriority() {
        int expected = 10;
        int actual = task.getPriority();
        assertEquals(expected, actual, 0.02);
    }

    @Test
    public void perform() {
        int expected = 2000;
        long start= System.currentTimeMillis();
        task.perform();
        long end = System.currentTimeMillis();
        assertEquals(expected, end-start, 1500);
    }
}