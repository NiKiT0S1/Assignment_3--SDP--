// Interface for complete tasks
interface Cmd {
    void execute();
}

// Representing the tasks
class TaskCommand {
    private String name;

    public TaskCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class for printing tasks
class PrintCommand implements Cmd {
    private TaskCommand task;

    public PrintCommand(TaskCommand task) {
        this.task = task;
    }

    @Override
    public void execute() {
        System.out.println("Printing task: " + task.getName());
    }
}

// Class for saving tasks
class SaveCommand implements Cmd {
    private TaskCommand task;

    public SaveCommand(TaskCommand task) {
        this.task = task;
    }

    @Override
    public void execute() {
        System.out.println("Saving task: " + task.getName());
    }
}

// Class for calling tasks
class CallCommand {
    private Cmd command;

    public void setCommand(Cmd command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

// TEST
public class Command {
    public static void main (String[] args) {
        TaskCommand task = new TaskCommand("TASK");

        Cmd print = new PrintCommand(task);
        Cmd save = new SaveCommand(task);

        CallCommand call = new CallCommand();

        call.setCommand(print);
        call.executeCommand();

        call.setCommand(save);
        call.executeCommand();


    }
}
