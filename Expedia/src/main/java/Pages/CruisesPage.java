package Pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CruisesPage extends CommonAPI {

    public CruisesPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#primary-header-cruise")
    WebElement cruisesLink;

    @FindBy(xpath = "//h1[@class='wizard-tabs launch-page-title']")
    WebElement searchCruisesLabel;

    @FindBy(css = "#cruise-destination-cruiselp")
    Select destinationField;

    @FindBy(css = "#cruise-departure-month-cruiselp")
    Select departField;

    @FindBy(xpath = "//label[@class='col search-btn-col']//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//h3[contains(text(),'Expedia: Your First Stop for Discount Cruises')]")
    WebElement yourFirstStopforDiscountCruisesLabel;

    @FindBy(xpath = "//h3[contains(text(),'Cruise Deals and Discounts on the Best Cruise Line')]")
    WebElement cruiseDealsandDiscountsontheBestCruiseLinesLabel;

    @FindBy(xpath = "//h3[contains(text(),'Enjoy The Best Cruise Travel Destinations')]")
    WebElement enjoytThetBestCruiseTravelDestinationsLabel;

    @FindBy(xpath = "//h3[contains(text(),'Last Minute Cruise Deals & Vacation Ideas')]")
    WebElement lastMinuteCruiseDealsVacationIdeasLabel;

    @FindBy(xpath = "//h3[contains(text(),'Take A Vacation on These All Inclusive Cruises')]")
    WebElement takeAVacationonTheseAllInclusiveCruisesLabel;

    //actions
    public void pageTitleValidate(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Cruises: Find Cheap Cruise Deals & Last Minute Cruises | Expedia");
    }

    public void properUrl(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.expedia.com/Cruises");
    }

    public void headerLabelTextValidation(){
        String text = searchCruisesLabel.getText();
        Assert.assertTrue(text.contains("Search Cruises"));
    }

    public void cruisesLinkisUnderLined(){
        String borderProp = cruisesLink.getCssValue("border-bottom");
        Assert.assertTrue(borderProp.contains("solid"));
    }

    public void yourFirstStopforDiscountCruisesLabelVisibility(){
        Assert.assertTrue(yourFirstStopforDiscountCruisesLabel.isDisplayed());
    }

    public void cruiseDealsandDiscountsontheBestCruiseLinesLabelVisibility(){
        Assert.assertTrue((cruiseDealsandDiscountsontheBestCruiseLinesLabel.isDisplayed()));
    }

    public void enjoytThetBestCruiseTravelDestinationsLabelVisibility(){
        Assert.assertTrue(enjoytThetBestCruiseTravelDestinationsLabel.isDisplayed());
    }

    public  void lastMinuteCruiseDealsVacationIdeasLabelVisibility(){
        Assert.assertTrue(lastMinuteCruiseDealsVacationIdeasLabel.isDisplayed());
    }

    public void takeAVacationonTheseAllInclusiveCruisesLabelVisibility(){
        Assert.assertTrue((takeAVacationonTheseAllInclusiveCruisesLabel.isDisplayed()));
    }

    public void discountCruisesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div[1]//div[1]//ul[1]//a"));
        Assert.assertEquals(list.size(),6);
    }

    public void bestCruisesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div[2]//div[1]//ul[1]//a"));
        Assert.assertEquals(list.size(),5);
    }
    public void destinationCruisesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div[3]//div[1]//ul[1]//a"));
        Assert.assertEquals(list.size(),5);
    }
    public void lastMinuteCruisesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div[4]//div[1]//ul[1]//a"));
        Assert.assertEquals(list.size(),5);
    }

    public void allInclusiveCruisesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div[5]//div[1]//ul[1]//a"));
        Assert.assertEquals(list.size(),5);
    }

    public void searchCruises(){
        destinationField.selectByVisibleText("Mexico");
        departField.selectByVisibleText("December 2018");
        clickOnWebElement(searchButton);


    }
}
