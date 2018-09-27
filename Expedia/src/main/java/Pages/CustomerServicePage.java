package Pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    public String CSLabelText(){
        String text = CustomerServiceLabel.getText();
        return text;
    }

    public void verifyPhoneTextLabel() throws InterruptedException {
        phoneNumberInputBox.clear();
        phoneNumberInputBox.sendKeys("9172924196");
        SendButton.click();
        Thread.sleep(2000);
        WebElement labelText = driver.findElement(By.xpath("//div[@class='alert-message']"));
        Assert.assertEquals(labelText.getText(),"Thank you! A text with the download link has been sent to your mobile device");
    }


}
