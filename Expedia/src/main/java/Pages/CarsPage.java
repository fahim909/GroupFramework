package Pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CarsPage extends CommonAPI {

    public CarsPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#primary-header-car")
    WebElement carTab;

    @FindBy(xpath = "//h1[@class='wizard-tabs launch-page-title']")
    WebElement carPageBanner;

    @FindBy(css = "#tab-car-tab-clp")
    WebElement carOnlyTab;

    @FindBy(css = "#tab-carHotel-tab-clp-hc")
    WebElement carHotelTab;

    @FindBy(css = "#tab-carHotelFlight-tab-clp-fhc")
    WebElement carHotelFlightTab;

    @FindBy(css = "#tab-carFlight-tab-clp-fc")
    WebElement carFlightTab;

    @FindBy(css = "#aarp-car-rates-check-clp")
    WebElement aarpCheckBox;

    @FindBy(xpath = "//h3[contains(text(),'Domestic Car Rentals')]")
    WebElement domesticCarRentalsLabel;

    @FindBy(xpath = "//h3[contains(text(),'International Rental Car Deals')]")
    WebElement internationalRentalCarsDealLabel;

    //actions
    public void carTabIsUnderLined() {
        String bottom = carTab.getCssValue("border-bottom");
        boolean isUnderLined = bottom.contains("solid");
        Assert.assertTrue(isUnderLined);
    }

    public void carPageBannerIsDisplayed() {
        boolean displayed = carPageBanner.isDisplayed();
        Assert.assertTrue(displayed);
    }

    public void carPageBannerValidText(){
        String text = carPageBanner.getText();
        boolean properText = text.contains("Search Rental Car Deals");
        Assert.assertTrue(properText);
    }

    public void carTabIsSelected(){
        carTab.click();
        boolean isSelected = carOnlyTab.isSelected();
        Assert.assertTrue(isSelected);
    }
    public void carHotelTabIsSelected(){
        carHotelTab.click();
        boolean isSelected = carHotelTab.isSelected();
        Assert.assertTrue(isSelected);
    }
    public void carHotelFlightTabIsSelected(){
        carHotelFlightTab.click();
        boolean isSelected = carHotelFlightTab.isSelected();
        Assert.assertTrue(isSelected);
    }
    public void carFlightTabIsSelected(){
        carFlightTab.click();
        boolean isSelected = carFlightTab.isSelected();
        Assert.assertTrue(isSelected);
    }

    public void titleValidation(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Car Rental: Cheap Airport Car Rentals & Rental Car Deals | Expedia");
    }

    public void checkboxSelection(){
        aarpCheckBox.click();
        boolean selected = aarpCheckBox.isSelected();
        Assert.assertTrue(selected);
    }

    public void domesticRentalsLabelVisible(){
        boolean visible = domesticCarRentalsLabel.isDisplayed();
        Assert.assertTrue(visible);
    }

    public void internationalRentalCarsLineHeight(){
        String height = internationalRentalCarsDealLabel.getCssValue("line-height");
        Assert.assertEquals(height,"1.75");
    }

    public void domesticRentalsListCount() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div//ul[1]/li"));
        int count = list.size();
        Assert.assertEquals(count,15);
    }

    public void internationalRentalsListCount() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div//ul[2]/li"));
        int count = list.size();
        Assert.assertEquals(count,15);
    }

    public void properUrl(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.expedia.com/Cars");
    }
}
