package Pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CustomerServicePage extends CommonAPI {

    public CustomerServicePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[@class='aside-prompt']")
    WebElement CustomerServiceLabel;

    @FindBy(css = "#mad-t2d-form-input")
    WebElement phoneNumberInputBox;

    @FindBy(xpath = "//button[@class = 'btn-secondary btn-sub-action']")
    WebElement SendButton;

    @FindBy(xpath = "//a[contains(text(),'Add your property to Expedia')]")
    WebElement addPropertyButton;

    @FindBy(css = "#search-term")
    WebElement searchBox;



    public void CSLabelText(){
        String text = CustomerServiceLabel.getText();
        Assert.assertTrue(text.contains("We're here to help"));
    }

    public void verifyPhoneTextLabel() throws InterruptedException {
        phoneNumberInputBox.clear();
        phoneNumberInputBox.sendKeys("917-292-4196");
        SendButton.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement labelText;
        labelText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-message']")));
        Assert.assertEquals(labelText.getText(),"Thank you! A text with the download link has been sent to your mobile device");
    }

    public void verifyPropertyPageBannerText(){
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        addPropertyButton.click();// click some link that opens a new window
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        WebElement heroBannerText = driver.findElement(By.xpath("//p[contains(text(),'Signup is easy, free, and gives you exposure to ov')]"));
        String getText = heroBannerText.getText();
        //code to do something on new window
        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window
        Assert.assertEquals(getText,"Signup is easy, free, and gives you exposure to over 675 million monthly site visits.");
    }

    public void getSearchResultCount() throws InterruptedException {
        searchBox.clear();
        searchBox.sendKeys("lost bags", Keys.ENTER);
        Thread.sleep(2000);

        List list = driver.findElements(By.xpath("//section[@class='col']//ul[contains(@class,'segment')]/li"));
        Assert.assertEquals(list.size(),5);
    }

    public void properUrl(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.expedia.com/service/");
    }


}
