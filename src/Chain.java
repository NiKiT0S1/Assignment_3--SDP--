// CHAIN OF RESPONSIBILITY

// Representing the tasks
class TaskChain {
    // Listing priorities
    enum Priority { LOW, MEDIUM, HIGH }
    private Priority priority;
    private String name;

    public TaskChain(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }
}
// Abstract class for defines the main processing method
abstract class Handler {
    // Next handler in chain
    protected Handler next;

    // Method for setting next handler
    public void setNext(Handler next) {
        this.next = next;
    }

    // Abstract method, that will be implemented in subclasses
    public abstract void handleRequest(TaskChain task);
}

// Handler class for low-priority tasks
class LowPriorityHandler extends Handler {
    public void handleRequest(TaskChain task) {
        if (task.getPriority() == TaskChain.Priority.LOW) {
            System.out.println("Low priority handler called " + task.getName());
        }
        else if (next != null) {
            // Passing the task to the next handler
            next.handleRequest(task);
        }
    }
}

// Handler class for medium-priority tasks
class MediumPriorityHandler extends Handler {
    public void handleRequest(TaskChain task) {
        if (task.getPriority() == TaskChain.Priority.MEDIUM) {
            System.out.println("Medium priority handler called " + task.getName());
        }
        else if (next != null) {
            // Passing the task to the next handler
            next.handleRequest(task);
        }
    }
}

// Handler class for high-priority tasks
class HighPriorityHandler extends Handler {
    public void handleRequest(TaskChain task) {
        if (task.getPriority() == TaskChain.Priority.HIGH) {
            System.out.println("High priority handler called " + task.getName());
        }
        else if (next != null) {
            // Passing the task to the next handler
            next.handleRequest(task);
        }
    }
}

// TEST
class Chain {
    public static void main (String[] args) {
        Handler low = new LowPriorityHandler();
        Handler medium = new MediumPriorityHandler();
        Handler high = new HighPriorityHandler();

        // Setting the chain: from low to high
        low.setNext(medium);
        medium.setNext(high);
        high.setNext(low);

        TaskChain task1 = new TaskChain("Task 1", TaskChain.Priority.LOW);
        TaskChain task2 = new TaskChain("Task 2", TaskChain.Priority.MEDIUM);
        TaskChain task3 = new TaskChain("Task 3", TaskChain.Priority.HIGH);

        low.handleRequest(task1);
        low.handleRequest(task2);
        low.handleRequest(task3);
    }
}
