package Pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerServicePage extends CommonAPI {

    public CustomerServicePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[@class='aside-prompt']")
    WebElement CustomerServiceLabel;

    public String CSLabelText(){
        String text = CustomerServiceLabel.getText();
        return text;
    }

}
