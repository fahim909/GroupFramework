package Pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DealsPage extends CommonAPI {

    public DealsPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#primary-header-deals")
    WebElement dealsLink;

    @FindBy(xpath = "//h1[contains(text(),\"Today's Travel Deals\")]")
    WebElement todaysTravelDealsLabel;

    @FindBy(xpath = "//a[@href='http://www.expedia.com/p/info-partner/destinations/hawaii']")
    WebElement hawaiiLink;

    @FindBy(xpath = "//a[@href='/g/pt/ms-theme-ski?langid=1033']")
    WebElement skiLink;

    @FindBy(xpath = "//h3[contains(text(),'Vacation Package Deals')]")
    WebElement vacationPakageDealsLabel;

    @FindBy(xpath = "//h3[contains(text(),'Flight Deals')]")
    WebElement flightDealsLabel;

    @FindBy(xpath = "//h3[contains(text(),'Hotel Deals')]")
    WebElement hotelDealsLabel;

    @FindBy(xpath = "//h3[contains(text(),'Cruise Deals')]")
    WebElement cruiseDealsLabel;

    @FindBy(xpath = "//h3[contains(text(),'Car Rental Deals')]")
    WebElement carRentalDealsLabel;
    //actions
    public void properUrl() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.expedia.com/Deals");
    }
    public void pageTitleValidation(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Travel Deals: Find Cheap Deals on Travel, Trips & Tours | Expedia.com");
    }

    public void dealsLinkIsUnderlined(){
        String borderProp = dealsLink.getCssValue("border-bottom");
        Assert.assertTrue(borderProp.contains("solid"));
    }

    public void headerLabelTextValidation(){
        String text = todaysTravelDealsLabel.getText();
        Assert.assertTrue(text.contains("Today's Travel Deals"));
    }

    public void chooseClassVerification(){
        Select dropDown = new Select(driver.findElement(By.cssSelector("#F-Class")));
        dropDown.selectByVisibleText("Business");
        WebElement businessOption = driver.findElement(By.xpath("//option[@value='b']"));
        Assert.assertTrue(businessOption.isSelected());
    }

    public void hawaiiLinkValidation() throws InterruptedException {
        hawaiiLink.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"Hawaii Vacation Packages | Expedia");
    }

    public void skiLinkValidation() throws InterruptedException {
        skiLink.click();
        Thread.sleep(3000);
        WebElement skiPageBanner = driver.findElement(By.xpath("//h1[contains(text(),'Ski Mountain Vacations')]"));
        Assert.assertEquals(skiPageBanner.getText(),"Ski Mountain Vacations");
    }

    public void vacationPakageDealsLabelFontWeight(){
        String weight = vacationPakageDealsLabel.getCssValue("font-weight");
        Assert.assertEquals(weight,"700");
    }

    public void hotelDealsLabelcolor(){
        String color = hotelDealsLabel.getCssValue("color");
        Assert.assertEquals(color,"rgba(31, 31, 31, 1)");
    }

    public void flightDealsDisplay(){
        String display = flightDealsLabel.getAttribute("display");
        Assert.assertEquals(display,"block");
    }

    public void cruiseLabelBoxsize(){
        String boxSize = cruiseDealsLabel.getCssValue("box-sizing");
        Assert.assertEquals(boxSize,"border-box");
    }

    public void carRentalDealsLabelVisibility(){
        boolean visible = carRentalDealsLabel.isDisplayed();
        Assert.assertTrue(visible);
    }

    public void vacationDealsCount(){
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath("//div[@id='page-intro']//div[1]//div[1]//a"));
        Assert.assertEquals(list.size(),7);
    }

    public void hotelsDealsCount(){
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath("//div[@class='col']//div[2]//ul[1]//a"));
        Assert.assertEquals(list.size(),5);
    }

    public void flightDealsCount(){
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath("//div[@class='col']//div[3]//a"));
        Assert.assertEquals(list.size(),7);
    }

    public void cruiseDealsCount(){
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath("//div[@class='col']//div[4]//a"));
        Assert.assertEquals(list.size(),6);
    }

    public void carRentalDealsCount(){
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath("//div[@class='col']//div[5]//ul[1]//a"));
        Assert.assertEquals(list.size(),5);
    }
}
