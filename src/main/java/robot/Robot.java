package robot;

public class Robot {

    private String robotName;
    private String robotUrl;
    private int robotId;

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
}
