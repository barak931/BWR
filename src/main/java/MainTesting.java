import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import report.htmlReport.Report;
import rest.RestResponse;
import robot.Robots;
import tasks.Tasks;

public class MainTesting {

    private static final Logger logger = LogManager.getLogger(MainTesting.class.getName());
    private Robots robots;
    private Tasks tasks;
    private SoftAssert softAssert;
    private Report report;

    @BeforeClass
    public void setup(){
        logger.info("Setup test function");
        robots = new Robots();
        tasks = new Tasks();
        logger.info(robots.getRobot(0).getRobotName());
        report = new Report();
    }

    @Test(priority = 1)
    public void assignCommandTest(){
        logger.info("This is the first test -- This test will pass");
        RestResponse response = robots.getRobot(0).assignCommand(tasks.getTaskByIndex(1),true);
        softAssert.assertEquals(response.getStatusCode(),200);
        report.reportTestResult("Assign command positive","Assign command to Robot 1 -- Pass", true);
    }

    @Test(priority = 2)
    public void assignCommandTestFail(){
        logger.info("Second test -- This test will fail");
        RestResponse response = robots.getRobot(0).assignCommand(tasks.getTaskByIndex(3),false);
        softAssert.assertEquals(response.getStatusCode(),200);
        report.reportTestResult("Assign command negative","Assign command to Robot 1 -- Fail", false);
    }

    @AfterClass
    private void tearDown(){
        softAssert.assertAll();
        report.flush();
    }


}
