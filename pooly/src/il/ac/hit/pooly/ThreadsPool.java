package il.ac.hit.pooly;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.*;



public class ThreadsPool {

    private final int numThreads;
    public ThreadPoolExecutor tpe ;
    private PriorityBlockingQueue queue ;
    public ThreadsPool(int numThreads) {
        this.numThreads = numThreads;
        queue = new PriorityBlockingQueue();
        tpe = new ThreadPoolExecutor(
                numThreads, // core pool size
                numThreads, // maximum pool size
                1, // keep alive time
                TimeUnit.SECONDS, // keep alive time unit
                queue // priority queue for tasks
        );
    }

    public int getNumThreads() {
        return numThreads;
    }

    public void submit(Task task) {
        tpe.execute(task);


    }
}
