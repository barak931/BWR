package report.htmlReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import java.io.File;

public class Report {

    ExtentReports extentReports;
    ExtentTest extentTest;

    public Report(){
        extentReports = new ExtentReports(System.getProperty("user.dir")+"/Report.html", NetworkMode.ONLINE);
        extentReports.loadConfig(new File(Report.class.getResource("/extent-config.xml").getFile()));
    }

    public void reportTestResult(String testName,String details, boolean pass){
        extentTest = extentReports.startTest(testName);
        extentTest.log(pass?LogStatus.PASS:LogStatus.FAIL,testName,details);
        extentReports.endTest(extentTest);
    }

    public void flush(){
        extentReports.flush();
    }
}
