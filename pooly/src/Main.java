import il.ac.hit.pooly.Task;
import il.ac.hit.pooly.ThreadsPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadsPool pool = new ThreadsPool(5); // Create a thread pool with 3 threads
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            Task task = new ExampleTask("Task " + i, i);
            tasks.add(task);
            pool.submit(task);
        }
        System.out.println("done");
        if(pool.tpe.isTerminated()){
            pool.tpe.shutdown();
            System.out.println("terminated");
        }
        else{
            System.out.println("not terminated");
        }
    }
}



