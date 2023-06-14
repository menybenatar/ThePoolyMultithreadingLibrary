package il.ac.hit.pooly.tests;

import il.ac.hit.pooly.Task;
import il.ac.hit.pooly.ThreadsPool;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ThreadsPoolTest {

    private ThreadsPool pool;
    private List<Task> tasks;
    @Before
    public void setUp() throws Exception {
        pool = new ThreadsPool(1);
        tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(new ExampleTask("Task " + i, i));
        }
    }
    @After
    public void tearDown() throws Exception {
        tasks.clear();
        tasks = null;
        pool = null;
    }

    @Test
    public void submit() throws InterruptedException {
        int expected = 10000;
        long start = System.currentTimeMillis();
        for (Task task: tasks) {
            pool.submit(task);
        }
        pool.shutdown(); // close the executor and don't accept new tasks
        while (!pool.awaitTermination(100)){}
        long end = System.currentTimeMillis();
        assertEquals(expected, end-start, 4000);
    }
}