package Pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThingsToDoPage extends CommonAPI {

    public ThingsToDoPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#activity-destination-hp-activity")
    WebElement destinationInput;
    @FindBy(css = "#activity-start-hp-activity")
    WebElement startDateinput;
    @FindBy(css = "#activity-end-hp-activity")
    WebElement endDateInput;
    @FindBy(xpath = "//form[@id='gcw-activities-form-hp-activity']//button[@type='submit']")
    WebElement searchButton;

    // actions
    public void fillThingsToDoForm(String destination, String start, String end){
        typeOnWebElement(destinationInput,destination);
        typeOnWebElement(startDateinput,start);
        typeOnWebElement(endDateInput,end);
        clickOnWebElement(searchButton);
    }

}
