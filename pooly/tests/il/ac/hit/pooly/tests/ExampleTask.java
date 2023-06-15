package il.ac.hit.pooly.tests;

import il.ac.hit.pooly.Task;

/**
 * The ExampleTask class represents an example task implementation.
 */
class ExampleTask implements Task {
    private final String name; // The name of the task
    private int priority; // The priority level of the task

    /**
     * Constructs an ExampleTask object with the specified name and priority.
     *
     * @param name     the name of the task
     * @param priority the priority level of the task
     */
    public ExampleTask(String name, int priority) {
        this.name = name;
        setPriority(priority);
    }

    /**
     * Sets the priority level of the task.
     *
     * @param level the priority level to set
     */
    @Override
    public void setPriority(int level) {
        this.priority = level;
    }

    /**
     * Gets the priority level of the task.
     *
     * @return the priority level of the task
     */
    @Override
    public int getPriority() {
        return priority;
    }

    /**
     * Performs the task.
     * It simulates a task execution by performing calculations and sleeping for 2 seconds.
     */
    @Override
    public void perform() {
        try {
            System.out.println("Task " + name + " started execution.");
            int y = 0;
            for (int i = 0; i < 10000000; i++) {
                for (int j = 0; j < 99; j++) {
                    y += j * j;
                }
            }
            System.out.println("Task " + name + " finished execution.");
            // Introduce an artificial delay of 2 seconds to simulate task execution time
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Exception occurred if the task was interrupted while sleeping
            throw new RuntimeException("Task execution interrupted", e);
        }
    }
}