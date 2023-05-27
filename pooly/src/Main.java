import il.ac.hit.pooly.Task;
import il.ac.hit.pooly.ThreadsPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadsPool pool = new ThreadsPool(1); // Create a thread pool with 3 threads
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            Task task = new ExampleTask("Task " + i, i);
            tasks.add(task);
            pool.submit(task);
        }


    }
}



