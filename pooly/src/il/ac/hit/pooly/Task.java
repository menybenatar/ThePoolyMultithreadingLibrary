package il.ac.hit.pooly;

/**
 * The Task interface represents a task to be executed by the ThreadsPool.
 */
public interface Task extends Runnable, Comparable<Task> {
    /**
     * Performs the task.
     */
    public abstract void perform();

    /**
     * Sets the priority level of the task.
     *
     * @param level the priority level to set
     */
    public abstract void setPriority(int level);

    /**
     * Gets the priority level of the task.
     *
     * @return the priority level of the task
     */
    public abstract int getPriority();

    @Override
    default void run() {
        perform();
    }
    @Override
    default int compareTo(Task that) {
        return -1 * Integer.compare(this.getPriority(), that.getPriority());
    }
}
