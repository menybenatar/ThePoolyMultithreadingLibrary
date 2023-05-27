package il.ac.hit.pooly;

public interface Task extends  Runnable, Comparable<Task> {
    void setPriority(int level);
    int getPriority();

    @Override
    default void run() {
        perform();
    }

    void perform();

    @Override
    default int compareTo(Task that) {
        return -1 * Integer.compare(this.getPriority(), that.getPriority());
    }
}

