package Pages;

import base.CommonAPI;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FlightsPage extends CommonAPI {
    public static Logger log = Logger.getLogger(FlightsPage.class);
    public FlightsPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#primary-header-flight")
    WebElement flightsLink;

    @FindBy(xpath = "//h1[@class='wizard-tabs launch-page-title']")
    WebElement searchFlightsLabel;

    @FindBy(css = "#flight-advanced-options-flp")
    WebElement advancedOptions;

    @FindBy(css = "#flight-advanced-preferred-airline-flp")
    Select preferedAirlines;

    @FindBy(xpath = "//img[@title='Expedia.com']")
    WebElement addOnAdvantageImg;

    @FindBy(xpath = "//h3[contains(text(),'Popular Flights & Discount Airfare')]")
    WebElement popularFlightsNDiscountAirfareLabel;

    @FindBy(xpath = "//h3[contains(text(),'Popular Flight Routes')]")
    WebElement popularFlightRoutesLabel;



    //actions
    public void properUrl(){
        String url = driver.getCurrentUrl();
        log.info("testing the url");
        Assert.assertEquals(url,"https://www.expedia.com/Flights");
    }

    public void pageTitleValidation(){
        String title = driver.getTitle();
        log.info("testing title of page");
        Assert.assertEquals(title,"Cheap Flights: Airline Tickets, Airfare Deals & One Way Flights | Expedia");
    }

    public void flightslinkIsUnderlined(){
        String borderProp = flightsLink.getCssValue("border-bottom");
        Assert.assertTrue(borderProp.contains("solid"));
    }

    public void headerLabelTextValidation(){
        String text = searchFlightsLabel.getText();
        Assert.assertTrue(text.contains("Search Flights"));
    }

    public void dropDownValidation(){
        advancedOptions.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement nonStopRadioBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#advanced-flight-nonstop-flp")));
        nonStopRadioBox.click();
        boolean selected = nonStopRadioBox.isSelected();
        Assert.assertTrue(selected);
    }

    public void airlinesDropDown(){
        preferedAirlines.selectByVisibleText("Emirates");
        boolean isSelected = driver.findElement(By.xpath("//option[@value='EK']")).isSelected();
        Assert.assertTrue(isSelected);
    }

    public void addOnAdvantageImgUrlValidation(){
        String url = addOnAdvantageImg.getAttribute("src");
        Assert.assertEquals(url,"https://www.expedia.com/_dms/group/addon/expedia/inline/logo.svg?locale=en_US&siteid=1");
    }

    public void popularFlightsNDiscountAirfareLabelVisibility(){
        Assert.assertTrue(popularFlightRoutesLabel.isDisplayed());
    }

    public void popularFlightRoutesLabelVisibility(){
        Assert.assertTrue(popularFlightRoutesLabel.isDisplayed());
    }

    public void discountAirfareLinksCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div//ul[1]//a"));
        int size = list.size();
        Assert.assertEquals(size,17);
    }

    public void popularFlightRoutesLinksCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div//ul[2]//a"));
        int size = list.size();
        Assert.assertEquals(size,15);
    }
}
