package Pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignUpPage extends CommonAPI {

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#create_account_first_name_label [type]")
    WebElement FirstNameField;

    public void typeFirstName(String firstName) {
        FirstNameField.sendKeys(firstName);
    }

    @FindBy(css = "#create_account_last_name_label [type]")
    WebElement LastNameField;

    public void typeLastName(String LastName) {
        LastNameField.sendKeys(LastName);
    }

    @FindBy(css = "#create_email_label [type]")
    WebElement EmailField;

    public void typeEmail(String email) {
        EmailField.sendKeys(email);
    }

    @FindBy(css = "#create-password [type]")
    WebElement PasswordField;

    public void typePassword(String Pass) {
        EmailField.sendKeys(Pass);

    }

    @FindBy(css = "#create_confirm_password_error_label [type]")
    WebElement confirmPasswordField;

    public void typeConfirmPass(String Pass) {
        confirmPasswordField.sendKeys(Pass);
    }

    @FindBy(css = "#create-account-expedia-policy")
    WebElement AgreeCheckBox;

    public void ClickAgree() {
        AgreeCheckBox.click();
    }

    @FindBy(css = "#create-account-submit-button")
    WebElement CreateAccountButton;

    public void clickCreateAccountButton() {
        CreateAccountButton.click();
    }

    @FindBy(css = "div.recaptcha-checkbox-checkmark")
    WebElement HumanCheckbox;

    public boolean isHumanCheckBoxVisible() {
        return HumanCheckbox.isDisplayed();
    }

    public void clickHumanCheckBox() {
        HumanCheckbox.click();
    }

    public void verifyHumanOrRobotPageTitle(){
        String title =  driver.getTitle();
        Assert.assertEquals(title,"Bot or Not?");
    }
}
