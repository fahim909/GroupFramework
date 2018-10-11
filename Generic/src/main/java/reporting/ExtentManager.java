package reporting;

import base.CommonAPI;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;

public class ExtentManager{
    private static ExtentReports extent;
    private static ITestContext context;

    public static ExtentReports getInstance(){
        ExtentReports extent;
        String Path = System.getProperty("user.dir")+"/Extent-Report/ExtentReport.html";
        extent = new ExtentReports(Path,true);
        extent
                .addSystemInfo("Selenium Version","3.14.0")
                .addSystemInfo("User Name", "Juned Alam")
                .addSystemInfo("Environment","QA")
                .addSystemInfo("Platform","Mac");
        extent.loadConfig(new File(System.getProperty("user.dir")+ "/report-config.xml"));
        return extent;
    }

}
