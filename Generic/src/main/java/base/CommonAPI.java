

package base;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import utilities.WebEventListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

     public static WebDriver driver;
     public static EventFiringWebDriver e_driver;
     public static WebEventListener eventListener;
     public static String UserName = "lowang1";
     public static String AccessKey = "sCddh1m4bqBpEF5az9wF";
     public CommonAPI(){
     }

    @BeforeMethod
    @Parameters({"platform", "browser", "url","useCloud"})
    public static void setUp(@Optional("Mac") String platform,@Optional("chrome") String browser,@Optional("https://www.expedia.com/") String url,@Optional("false") boolean useCloud) throws MalformedURLException {
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
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1440, 900));
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
    public static void typeOnWebElement(WebElement we, String value) {
       we.sendKeys(value);
    }
    public  static void clickOnWebElement(WebElement we){
        we.click();
    }
    public static String convertToString(String st){
        String splitString ;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }
}