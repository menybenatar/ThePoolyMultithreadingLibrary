import il.ac.hit.pooly.Task;

public class Mission implements Task {

    private int priority = 0;

    @Override
    public void perform() {
        System.out.println("test : " + priority);
    }

    @Override
    public void setPriority(int level) {
        this.priority = level;

    }

    @Override
    public int getPriority() {
        return this.priority;
    }
}


class ExampleTask implements Task {
    private final String name;
    private int priority;

    public ExampleTask(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public void setPriority(int level) {
        this.priority = level;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void perform() {
       System.out.println("Task " + name + " started execution."); // Print when the task starts executing
       for (int i = 0; i < 9; i++) {
           int x = i*i;
           for (int j = 0; j < 9; j++) {
               int y = j*j;

           }
       }
        System.out.println("Task " + name + " finished execution."); // Print when the task finishes executing
    }
}
