import java.util.ArrayList;
import java.util.List;

// Interface to iterate through elements
interface MyIterator<T> {
    // Method for checking the presence of the following element
    boolean hasNext();
    // Method for getting the next element
    T next();
}

// Representing the tasks
class TaskIterator {
    private String name;

    public TaskIterator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class for specific implementation of the Iterator interface
class TaskIIterator implements MyIterator<TaskIterator> {
    // Collection of tasks
    private List<TaskIterator> tasks;
    // Current position in the collection
    private int position = 0;

    public TaskIIterator(List<TaskIterator> tasks) {
        this.tasks = tasks;
    }

    // Checking if the next element exists
    @Override
    public boolean hasNext() {
        return position < tasks.size();
    }

    // Returns the current task and increments the position
    @Override
    public TaskIterator next() {
        return tasks.get(position++);
    }
}

// A collection of tasks that uses an iterator
class TaskCollection {
    private List<TaskIterator> tasks = new ArrayList<>();

    public void addTask(TaskIterator task) {
        tasks.add(task);
    }

    public MyIterator<TaskIterator> iterator() {
        return new TaskIIterator(tasks);
    }
}

// TEST
public class Iterator {
    public static void main(String[] args) {
        TaskCollection taskCollection = new TaskCollection();

        taskCollection.addTask(new TaskIterator("Task 1"));
        taskCollection.addTask(new TaskIterator("Task 2"));
        taskCollection.addTask(new TaskIterator("Task 3"));

        MyIterator<TaskIterator> iterator = taskCollection.iterator();

        // Iterating through tasks using the iterator
        while (iterator.hasNext()) {
            TaskIterator task = iterator.next();
            System.out.println("Processing task: " + task.getName());
        }
    }
}
