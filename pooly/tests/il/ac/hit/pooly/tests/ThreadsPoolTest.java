package il.ac.hit.pooly.tests;

import il.ac.hit.pooly.Task;
import il.ac.hit.pooly.ThreadsPool;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ThreadsPoolTest {

    private ThreadsPool pool;
    private List<Task> tasks;

    /**
     * Sets up the ThreadsPool and tasks before each test case.
     *
     * @throws Exception if an exception occurs during setup
     */
    @Before
    public void setUp() throws Exception {
        pool = new ThreadsPool(1);
        tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(new ExampleTask("Task " + i, i));
        }
    }

    /**
     * Cleans up the tasks and ThreadsPool after each test case.
     *
     * @throws Exception if an exception occurs during cleanup
     */
    @After
    public void tearDown() throws Exception {
        tasks.clear();
        tasks = null;
        pool = null;
    }

    /**
     * Test case for submit() method.
     *
     * @throws InterruptedException if the thread is interrupted during execution
     */
    @Test
    public void submit() throws InterruptedException {
        int expected = 10000;
        long start = System.currentTimeMillis();
        for (Task task: tasks) {
            pool.submit(task);
        }
        pool.shutdown(); // close the executor and don't accept new tasks
        while (!pool.awaitTermination(100)) {} // wait for all tasks to finish
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        assertEquals(expected, elapsedTime, 4000);
    }
}