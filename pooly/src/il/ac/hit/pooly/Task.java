package il.ac.hit.pooly;

/**
 * The Task interface represents a task to be executed by the ThreadsPool.
 */
public interface Task extends Runnable, Comparable<Task> {
    /**
     * Performs the task.
     */
    void perform();

    /**
     * Sets the priority level of the task.
     *
     * @param level the priority level to set
     */
    void setPriority(int level);

    /**
     * Gets the priority level of the task.
     *
     * @return the priority level of the task
     */
    int getPriority();

    /**
     * Executes the task by calling the perform() method.
     * This method is implemented from the Runnable interface.
     */
    @Override
    default void run() {
        perform();
    }

    /**
     * Compares this task's priority with another task's priority.
     * This method is implemented from the Comparable interface.
     *
     * @param that the task to compare with
     * @return a negative integer, zero, or a positive integer if this task's priority is less than, equal to, or greater than the specified task's priority
     */
    @Override
    default int compareTo(Task that) {
        return -1 * Integer.compare(this.getPriority(), that.getPriority());
    }
}