package Pages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends CommonAPI {

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

@FindBy(css = ".gcw-storeable.on .icons-container")
    WebElement FlightOnlyTab;

/*
@FindBy(css = "")
    WebElement  ;
*/


    @FindBy(css = ".tab:nth-of-type(2) .icons-container")
    WebElement FlightnHotelTab ;

    @FindBy(css = ".tab:nth-of-type(3) .icons-container")
    WebElement FlightHotelCarTab ;

    @FindBy(css = ".tab:nth-of-type(4) .icons-container")
    WebElement  FlightnCarTab;

    @FindBy(css = "#flight-type-roundtrip-label-flp")
    WebElement RoundTripButton ;

    @FindBy(css = "#flight-type-one-way-label-flp")
    WebElement OneWayButton  ;

    @FindBy(css = "#flight-type-multi-dest-label-flp")
    WebElement MultiCityButton ;

    @FindBy(css = "#gcw-flights-form-flp .gcw-location-field:nth-of-type(1) [data-version]")
    WebElement FlyFromField ;

    @FindBy(css = "[data-hotel_id_element='flight-destination-flp-hotel_id']")
    WebElement  FlyingToField;

    @FindBy(css = "#flight-departing-flp")
    WebElement DepartingField ;

    @FindBy(css = "#flight-returning-flp")
    WebElement  ReturningField;

    @FindBy(css = "#flight-returning-flp")
    WebElement TravelersTab  ;

    @FindBy(xpath = "//button[@xpath = '35']")
    WebElement AdultsPlusOne ;

    @FindBy(xpath = "//button[@xpath = '1']")
    WebElement AdultsMinusOne ;

    @FindBy(xpath = "//fieldset[@class='room-data']//div[@class='children-wrapper']//div[@class='uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized']//div[4]//button[1]")
    WebElement ChildrenPlusOne  ;

    @FindBy(xpath = "//fieldset[@class='room-data']//div[@class='children-wrapper']//div[@class='uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized']//div[2]")
    WebElement ChildrenMinusOne ;

    @FindBy(xpath = "//fieldset[@class='room-data']//div[@class='infants-wrapper']//div[@class='uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized']//div[4]//button[1]")
    WebElement InfantsPlusONe  ;

    @FindBy(xpath = "//fieldset[@class='room-data']//div[@class='infants-wrapper']//div[@class='uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized']//div[2]")
    WebElement InfantsMinusOne ;

    @FindBy(xpath = "//Button[@class = 'close btn-text' and @xpath = '1']")
    WebElement TravelersCloseButton ;

    @FindBy(css = "#gcw-flights-form-flp [type='submit']")
    WebElement FlightOnlySearchButton ;

    public void click( WebElement webElement){
        webElement.click();
    }
}

