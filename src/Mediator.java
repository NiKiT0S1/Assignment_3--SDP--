// MEDIATOR

// Interface to interaction between objects
interface MMediator {
    void send(TaskMed task, HandlerMed handler);
}
// Representing the tasks
class TaskMed {
    private String name;

    public TaskMed(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class for processing tasks
abstract class HandlerMed {
    protected MMediator mediator;

    public HandlerMed(MMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void handleMedRequest(TaskMed task);
}

// A specific handler that uses a mediator
class CertainHandler extends HandlerMed {
    public CertainHandler(MMediator mediator) {
        super(mediator);
    }

    @Override
    public void handleMedRequest(TaskMed task) {
        System.out.println("Handler processing: " + task.getName());
        mediator.send(task, this);
    }
}

// Class for implements interface "MMediator" for managing interactions
class TaskMediator implements MMediator {
    @Override
    public void send(TaskMed task, HandlerMed handler) {
        System.out.println("Mediator coordinating: " + task.getName());
    }
}

// TEST
public class Mediator {
    public static void main(String[] args) {
        MMediator mediator = new TaskMediator();

        // Create handler that implemented a mediator
        HandlerMed handlerMed = new CertainHandler(mediator);

        // Create the task and processing it through a mediator
        TaskMed task = new TaskMed("TASK");

        handlerMed.handleMedRequest(task);
    }
}
