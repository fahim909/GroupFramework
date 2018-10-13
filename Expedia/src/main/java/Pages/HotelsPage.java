package Pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HotelsPage extends CommonAPI {

    public HotelsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[contains(text(),'U.S. Hotel Discounts')]")
    WebElement USHotelDiscountsLabel;

    @FindBy(xpath = "//h3[contains(text(),'Europe Hotel Reservations')]")
    WebElement EuropeHotelLabel;

    @FindBy(xpath = "//h3[contains(text(),'More International Hotels')]")
    WebElement MoreInternationalLabel;

    @FindBy(xpath = "//fieldset[@class='text']//button[@type='button']")
    WebElement sendButton;

    @FindBy(xpath = "//a[contains(text(),'Add your property to Expedia')]")
    WebElement addPropertyButton;

    @FindBy(xpath = "//img[@src='//a.travel-assets.com/mad-service/qr-code/150/1.jpg']")
    WebElement qrCode;

    @FindBy(xpath = "//div[@class='legal']")
    WebElement legalDiv;

    @FindBy(xpath = "//h3[contains(text(),\"Today's Top Deals\")]")
    WebElement todaysTopDealsLabel;

    @FindBy(xpath = "//a[@href = \"#exploreMore\"]")
    WebElement  exploreMore;

    @FindBy(css = "#primary-header-hotel")
    WebElement hotelsLink;

    public void validateLabelHotelDiscount(){
        String label = USHotelDiscountsLabel.getText();
        boolean contains = label.contains("U.S. Hotel Discounts");
        Assert.assertTrue(contains);
    }

    public void validateLabelEuropeHotels(){
        String label = EuropeHotelLabel.getText();
        boolean contains = label.contains("Europe Hotel Reservations");
        Assert.assertTrue(contains);
    }

    public void validateLabelInternationalHotel(){
        String label = MoreInternationalLabel.getText();
        boolean contains = label.contains("More International Hotels");
        Assert.assertTrue(contains);
    }

    public void validateUsHotelLinkCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div//ul[1]/li"));
        int count = list.size();
        Assert.assertEquals(count,15);
    }
    public void validateEuropeHotelLinkCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div//ul[2]/li"));
        int count = list.size();
        Assert.assertEquals(count,15);
    }
    public void validateInternationalHotelLinkCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div//ul[3]/li"));
        int count = list.size();
        Assert.assertEquals(count,15);
    }

    public void sendButtonBorderRadius(){
        String radius = sendButton.getCssValue("border-radius");
        Assert.assertEquals(radius,"5px");
    }

    public void addPropertyButtonColor(){
        String color = addPropertyButton.getCssValue("color");
        Assert.assertEquals(color,"rgba(0, 101, 184, 1)");
    }

    public void isQRCodeDisplayed(){
        boolean visible = qrCode.isDisplayed();
        Assert.assertTrue(visible);
    }

    public void countGlobalLinks(){
        List<WebElement> list = driver.findElements(By.xpath("//ul[@id='global-sites-links']//a"));
        int count = list.size();
        Assert.assertEquals(count,41);
    }

    public void legalDivText(){
        String text = legalDiv.getText();
        boolean conatains2018 = text.contains("2018");
        Assert.assertTrue(conatains2018);
    }

    public void todaysTopDealBoxSize(){
        String text = todaysTopDealsLabel.getCssValue("box-sizing");
        Assert.assertEquals(text,"border-box");
    }

    public void exploreMoreAttribute(){
        String href = exploreMore.getAttribute("href");
        Assert.assertEquals(href,"https://www.expedia.com/Hotels#exploreMore");
    }

    public void titleValidation(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Hotels: Search Cheap Hotels, Deals, Discounts & Reservations | Expedia");
    }
    public void properUrl(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.expedia.com/Hotels");
    }

    public void hotelsLinkIsUnderlined(){
        String borderProp = hotelsLink.getCssValue("border-bottom");
        Assert.assertTrue(borderProp.contains("solid"));
    }

}
