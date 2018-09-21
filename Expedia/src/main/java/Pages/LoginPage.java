package Pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonAPI {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class='message-color base-font']")
    WebElement formLabel;

    public String returnlabelText(){
        return formLabel.getText();
    }

    public boolean isLabelDisplayed(){
        return formLabel.isDisplayed();
    }

    @FindBy(css = "#signin-loginid")
    WebElement emailField;

    public void typeEmail(String str){
        emailField.sendKeys(str);
    }

    @FindBy(css = "#signin-password")
    WebElement passwordField;

    public void typePassword(String str){
        passwordField.sendKeys(str);
    }

    @FindBy(css = "#submitButton")
    WebElement submitButton;

    public HomePage clickSubmitBUtton(){
        submitButton.click();
        return new HomePage();
    }

    public String returnUrl(){
        return driver.getCurrentUrl();
    }



}
