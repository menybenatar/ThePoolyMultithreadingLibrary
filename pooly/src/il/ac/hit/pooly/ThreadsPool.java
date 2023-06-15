package il.ac.hit.pooly;

import java.util.concurrent.*;

/**
 * The ThreadsPool class represents a pool of threads that can handle tasks with priorities.
 */
public class ThreadsPool {
    private int numThreads; // The number of threads in the pool
    private final ThreadPoolExecutor tpe; // The ThreadPoolExecutor instance

    /**
     * Constructs a ThreadsPool object with the specified number of threads.
     *
     * @param numThreads the number of threads in the pool
     */
    public ThreadsPool(int numThreads) {
        try {
            this.setNumThreads(numThreads);

            // Create a ThreadPoolExecutor with the specified parameters
            tpe = new ThreadPoolExecutor(
                    getNumThreads(), // core pool size
                    getNumThreads(), // maximum pool size
                    1, // keep alive time
                    TimeUnit.SECONDS, // keep alive time unit
                    new PriorityBlockingQueue<>() // priority queue for tasks
            );
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Sets the number of threads in the pool.
     *
     * @param numThreads the number of threads to set
     * @throws IllegalArgumentException if the number of threads is less than 1
     */
    public void setNumThreads(int numThreads) {
        if (numThreads < 1) {
            throw new IllegalArgumentException("Number of threads must be greater than 0");
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

    /**
     * Shuts down the thread pool.
     */
    public void shutdown() {
        tpe.shutdown();
    }

    /**
     * Blocks until all tasks have completed execution after a shutdown request,
     * or the timeout occurs, or the current thread is interrupted, whichever happens first.
     *
     * @param timeout the maximum time to wait
     * @return true if this thread pool terminated and false if the timeout elapsed before termination
     * @throws InterruptedException if interrupted while waiting
     */
    public boolean awaitTermination(long timeout) throws InterruptedException {
        return tpe.awaitTermination(timeout, TimeUnit.MILLISECONDS);
    }

    /**
     * Returns a string representation of the ThreadsPool object.
     *
     * @return a string representation of the ThreadsPool object
     */
    @Override
    public String toString() {
        return "ThreadsPool {" +
                "numThreads=" + numThreads +
                ", tpe=" + tpe +
                '}';
    }
}