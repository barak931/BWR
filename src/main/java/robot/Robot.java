package robot;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import rest.RequestBodyEditor;
import rest.Rest;
import rest.RestResponse;
import tasks.Task;

public class Robot {

    Logger logger = LogManager.getLogger("Robot");
    private String robotName;
    private String robotUrl;
    private int robotId;
    Rest rest = new Rest();

    public Robot(String robotName, String robotUrl, int robotId) {
        this.robotName = robotName;
        this.robotUrl = robotUrl;
        this.robotId = robotId;
    }

    public String getRobotName() {
        return robotName;
    }

    public String getRobotUrl() {
        return robotUrl;
    }

    public int getRobotId() {
        return robotId;
    }

    public RestResponse assignCommand(Task task, boolean pass){
        logger.info("Hello this is robot " + this.robotId + " and i am assigned the " + task.getCommand() + " command");
        return rest.postRequestRobot(RequestBodyEditor.editAssignCommand(this,task),this,pass);
    }
}
