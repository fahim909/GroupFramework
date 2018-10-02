

package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentReporterNG;
import utilities.WebEventListener;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

     public static WebDriver driver;
     public static EventFiringWebDriver e_driver;
     public static WebEventListener eventListener;
     public static String UserName = "junedalam1";
     public static String AccessKey = "63mtFyCzVt7soLPZfeHM";
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
    @Parameters({"platform", "browser", "url","useCloud"})
    public static void setUp(@Optional("Mac") String platform,@Optional("chrome") String browser,@Optional("https://www.expedia.com/") String url,boolean useCloud) throws MalformedURLException {
        if(useCloud==true){
            setUpBrowserStack();
            setEventListener();
            driver.get(url);
        }else {
            localDriver(platform, browser);
            setEventListener();
            driver.get(url);
        }
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }
    public static void setEventListener(){
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
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
public static void setUpBrowserStack() throws MalformedURLException {
    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability("browser","chrome");
    cap.setCapability("browser_version","68.0");
    cap.setCapability("os", "OS X");
    cap.setCapability("os_version", "Sierra");
    String browserStackUrl = "https://"+UserName+":"+AccessKey+"@hub-cloud.browserstack.com/wd/hub";
    URL serverUrl = new URL(browserStackUrl);
    driver = new RemoteWebDriver(serverUrl,cap);
}
    public void typeOnWebElement(WebElement we, String value) {
       we.sendKeys(value);
    }

    public void clickOnWebElement(WebElement we){
        we.click();
    }
}