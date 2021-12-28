import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import robot.Robots;

public class MainTesting {

    private static final Logger logger = LogManager.getLogger(MainTesting.class.getName());

    @BeforeClass
    public void setup(){
        logger.info("This is the Before Class setup function");
        Robots robots = new Robots();
        logger.info(robots.getRobot(0).getRobotName());
    }

    @Test
    public void firstTest(){
        logger.info("This is the first test");
    }



}
