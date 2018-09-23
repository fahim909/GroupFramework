

package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

     public static WebDriver driver;
     public CommonAPI(){
     }
    /**
     * Using parameters to make it more customizable, User is able to
     * provide desired information about @params[platform, browser, url]
     * in their TestNG.xml file rather than hard coding it.
     * @param platform
     * @param browser
     * @param url
     */


    @BeforeMethod
    @Parameters({"platform", "browser", "url"})
    public void initialize(String platform,String browser, String url) {
        setUp(platform, browser, url);

    }


//    public String browserstack_username= "junedalam1";
//    public String browserstack_accesskey = "63mtFyCzVt7soLPZfeHM";
//    public String saucelabs_username = "";
//    public String saucelabs_accesskey = "";
//
//    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion","url"})
//    @BeforeMethod
//    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false")String cloudEnvName,
//                      @Optional("OS X") String os,@Optional("10") String os_version, @Optional("chrome-options") String browserName, @Optional("34")
//                              String browserVersion, @Optional("http://www.amazon.com") String url)throws IOException {
//        System.setProperty("webdriver.chrome.driver", "/Users/peoplentech/eclipse-workspace-March2018/SeleniumProject1/driver/chromedriver");
//        if(useCloudEnv==true){
//            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
//                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browserName, browserVersion);
//            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
//                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browserName, browserVersion);
//            }
//        }else{
//            getLocalDriver(os, browserName);
//        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
//        driver.get(url);
//        driver.manage().window().maximize();
//    }
//    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName){
//        if(browserName.equalsIgnoreCase("chrome")){
//            if(OS.equalsIgnoreCase("OS X")){
//                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver");
//            }else if(OS.equalsIgnoreCase("Windows")){
//                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver.exe");
//            }
//            driver = new ChromeDriver();
//        } else if(browserName.equalsIgnoreCase("chrome-options")){
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-notifications");
//            if(OS.equalsIgnoreCase("OS X")){
//                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver");
//            }else if(OS.equalsIgnoreCase("Windows")){
//                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver.exe");
//            }
//            driver = new ChromeDriver(options);
//        }
//
//        else if(browserName.equalsIgnoreCase("firefox")){
//            if(OS.equalsIgnoreCase("OS X")){
//                System.setProperty("webdriver.gecko.driver", "../Generic/browser-driver/geckodriver");
//            }else if(OS.equalsIgnoreCase("Windows")) {
//                System.setProperty("webdriver.gecko.driver", "../Generic/browser-driver/geckodriver.exe");
//            }
//            driver = new FirefoxDriver();
//
//        } else if(browserName.equalsIgnoreCase("ie")) {
//            System.setProperty("webdriver.ie.driver", "../Generic/browser-driver/IEDriverServer.exe");
//            driver = new InternetExplorerDriver();
//        }
//        return driver;
//
//    }
//
//
//    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
//                                    String browserVersion)throws IOException {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("browser",browserName);
//        cap.setCapability("browser_version",browserVersion);
//        cap.setCapability("os", os);
//        cap.setCapability("os_version", os_version);
//        if(envName.equalsIgnoreCase("Saucelabs")){
//            //resolution for Saucelabs
//            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
//                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
//        }else if(envName.equalsIgnoreCase("Browserstack")) {
//            cap.setCapability("resolution", "1024x768");
//            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
//                    "@hub-cloud.browserstack.com/wd/hub"), cap);
//        }
//        return driver;
//    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


    public static void setUp(String platform, String browser, String url) {
        localDriver(platform, browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
        driver.get(url);
    }

    public static void localDriver(String platform, String browser) {
        if (platform.contains("Mac")) {
            if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver");
                driver = new FirefoxDriver();
            }
            else if (browser.equalsIgnoreCase("Safari")) {
                driver = new SafariDriver();
            }
        } else if (platform.contains("Win")) {
            if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }

    }

    /**
     * AfterMethod captures Screenshots with the help of 'captureScreenshot' method
     * Which get saved under screenshots directory under Users individual modules
     * and to make the names stand out from each other, Current Date is added
     * so User can distinguish the screenshots.

     */

//    @AfterMethod
//    public void captureScreenshotsIfFailure(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            captureScreenshot(result.getName());
//        }
//    }





    // Method to capture screenshot and provide current date
    private void captureScreenshot(String name) {
        DateFormat dateFormat = new SimpleDateFormat("(HH.mm.yyyy-HH;mma)");
        Date date = new Date();

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = null;

        if (System.getProperty("os.name").contains("Mac")) {
            screenshot = new File(System.getProperty("user.dir") +
                    "/screenshots/" + name + " " + dateFormat.format(date) + ".png");
        } else if (System.getProperty("os.name").contains("Win")) {
            screenshot = new File(System.getProperty("user.dir") +
                    "\\screenshots\\" + name + " " + dateFormat.format(date) + ".png");
        }
        try {
            FileUtils.copyFile(file, screenshot);
        } catch (IOException e) {

        }
    }
}