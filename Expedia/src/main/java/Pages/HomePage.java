package Pages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends CommonAPI {


@FindBy(css = "#tab-flight-tab-hp")
    WebElement FlightOnlyTab;

/*
@FindBy(css = "")
    WebElement  ;
*/

    @FindBy(xpath = "//img[@itemprop='image']")
    WebElement ExpediaLogo ;

    @FindBy(css = "#hero-banner")
    WebElement HeroBanner ;

    @FindBy(css = ".tab:nth-of-type(2) .icons-container")
    WebElement FlightnHotelTab ;

    @FindBy(css = ".tab:nth-of-type(3) .icons-container")
    WebElement FlightHotelCarTab ;

    @FindBy(css = ".tab:nth-of-type(4) .icons-container")
    WebElement  FlightnCarTab;

    @FindBy(css = "#flight-type-roundtrip-label-hp-flight")
    WebElement RoundTripButton ;

    @FindBy(css = "#flight-type-one-way-label-flp")
    WebElement OneWayButton  ;

    @FindBy(css = "#flight-type-multi-dest-label-flp")
    WebElement MultiCityButton ;

    @FindBy(css = "#flight-origin-hp-flight")
    WebElement FlyFromField ;

    @FindBy(css = "#flight-destination-hp-flight")
    WebElement  FlyingToField;

    @FindBy(css = "#flight-departing-hp-flight")
    WebElement DepartingField ;

    @FindBy(css = "#flight-returning-hp-flight")
    WebElement  ReturningField;

    @FindBy(css = "#tab-flight-tab-hp")
    WebElement TravelersTab;
    public void TravelorsTabclick(){
        System.out.println("travelors tab expected: "+TravelersTab.getAttribute("id")+" actual: "+TravelersTab.getAttribute("id"));
        TravelersTab.click();}


    @FindBy(xpath = "//button[@xpath = '35']")
    WebElement AdultsPlusOne ;
    public void AdultsPLusOneclick(){AdultsPlusOne.click();}

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

    @FindBy(xpath = "//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']")
    WebElement FlightOnlySearchButton ;

    @FindBy(xpath = "//span[@class='title-city-text']")
    WebElement DestinationCityResultText ;

    @FindBy(css = "#tab-openSearch-tab-hp")
    WebElement DiscoverButton ;

    @FindBy(css = "#openSearch-searchQuery-hp-openSearch")
    WebElement DiscoverSearchBox ;

    @FindBy(xpath = "//form[@id='gcw-open-search-form-hp-openSearch']//button[@type='submit']")
    WebElement DiscoverSearchButton ;




    public HomePage() {
    PageFactory.initElements(driver,this);
    }

    //Actions
    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public boolean ValidateExpediaLogo(){
       return ExpediaLogo.isDisplayed();
    }

    public String ShowHeroBannerImgSrc(){
         String style = HeroBanner.getAttribute("style");
       // String url = style.substring(style.indexOf('/'),style.indexOf())
        System.out.println(style);
        return style;
    }

    public boolean isHeroBannerDisplayed(){
        boolean result = HeroBanner.isDisplayed();
        // String url = style.substring(style.indexOf('/'),style.indexOf())
        return result;
    }
    public void searchRoundTripFlightOneAdult(String from, String destination,String departing, String returning){
        FlightOnlyTab.click();
        RoundTripButton.click();
        FlyFromField.sendKeys(from);
        FlyingToField.sendKeys(destination);
        DepartingField.sendKeys(departing);
        ReturningField.sendKeys(returning);
        FlightOnlySearchButton.click();
        String results = driver.getCurrentUrl();
        System.out.println(results);
    }

    public void DiscoverySearchTest(String destination){
        DiscoverButton.click();
        DiscoverSearchBox.sendKeys(destination);
        DiscoverSearchButton.click();
    }


}

