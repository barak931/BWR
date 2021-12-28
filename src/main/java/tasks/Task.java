package tasks;

public class Task {

    private String command;
    private String commandDescription;
    private int taskId;

    public Task(String command, String commandDescription, int taskId) {
        this.command = command;
        this.commandDescription = commandDescription;
        this.taskId = taskId;
    }

    public String getCommand() {
        return command;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public int getTaskId() {
        return taskId;
    }
}
