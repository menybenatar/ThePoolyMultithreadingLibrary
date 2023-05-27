package il.ac.hit.pooly;

import java.util.concurrent.*;

/**
 * The ThreadsPool class represents a pool of threads that can handle tasks with priorities.
 */
public class ThreadsPool {
    private int numThreads;
    private final ThreadPoolExecutor tpe;

    /**
     * Constructs a ThreadsPool object with the specified number of threads.
     *
     * @param numThreads the number of threads in the pool
     */
    public ThreadsPool(int numThreads) {
        this.setNumThreads(numThreads);
        tpe = new CustomThreadPoolExecutor(
                getNumThreads(), // core pool size
                getNumThreads(), // maximum pool size
                1, // keep alive time
                TimeUnit.SECONDS, // keep alive time unit
                new PriorityBlockingQueue<>() // priority queue for tasks
        );
    }

    /**
     * Sets the number of threads in the pool.
     *
     * @param numThreads the number of threads to set
     */
    public void setNumThreads(int numThreads) {
        if (numThreads < 1 ) {
            throw new IllegalArgumentException("Number of threads must greater than 0");
        }
        this.numThreads = numThreads;
    }

    /**
     * Gets the number of threads in the pool.
     *
     * @return the number of threads in the pool
     */
    public int getNumThreads() {
        return numThreads;
    }

    /**
     * Submits a task to the ThreadsPool for execution.
     *
     * @param task the task to submit
     */
    public void submit(Task task) {
        tpe.execute(task);
    }

    @Override
    public String toString() {
        return "ThreadsPool{" + "numThreads=" + numThreads + ", tpe=" + tpe + '}';
    }
}
