package il.ac.hit.pooly.tests;

import il.ac.hit.pooly.Task;

class ExampleTask implements Task {
    private final String name;
    private int priority;

    public ExampleTask(String name, int priority) {
        this.name = name;
        setPriority(priority);
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
    public void perform(){

        try {
            System.out.println("Task " + name + " started execution.");
            int y = 0;
            for (int i = 0; i < 10000000; i++) {
                for (int j = 0; j < 99; j++) {
                    y += j * j;
                }
            }
            System.out.println("Task " + name + " finished execution.");
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
        }
    }
}
