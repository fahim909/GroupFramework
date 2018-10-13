package Pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends CommonAPI {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class='message-color base-font']")
    WebElement formLabel;

    public String returnlabelText(){
        return formLabel.getText();
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
    public void validateUrl(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.expedia.com/user/signin");
    }

    public void loginValidation(){
        typeEmail("lowang22@gmail.com");
        typePassword("selenium4life");
        submitButton.click();
    }

    public void isLabelVisible(){
        boolean result = formLabel.isDisplayed();
        Assert.assertEquals(result,true);
    }

    public void validateLoginFormLabel(){
        String labelText = formLabel.getText();
        Assert.assertTrue(labelText.contains("Sign in with your email"));
    }
}




