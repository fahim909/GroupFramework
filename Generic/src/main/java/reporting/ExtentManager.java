package reporting;

import base.CommonAPI;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;

public class ExtentManager{
    private static ExtentReports extent;
    private static ITestContext context;

//    public synchronized static ExtentReports getInstance(){
//        if(extent == null){
//            File outputDirectory = new File(context.getOutputDirectory());
//            File resultDirectory = new File(outputDirectory.getParentFile(),"html");
//            extent = new ExtentReports(System.getProperty("user.dir")+"/Extent-Report/ExtentReport.html", true);
//            Reporter.log("Extent Report Directory"+ resultDirectory, true);
//            extent.addSystemInfo("Host Name", "PNT").addSystemInfo("Environment","QA")
//                    .addSystemInfo("User Name", "Juned Alam");
//            extent.loadConfig(new File(System.getProperty("user.dir")+ "/report-config.xml"));
//        }
//        return extent;
//    }
//
//    public static void setOutputDirectory(ITestContext context){
//        ExtentManager.context = context;
//
//    }

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
