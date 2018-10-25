package Pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
public class HomePage extends CommonAPI {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#tab-flight-tab-hp")
    WebElement FlightOnlyTab;

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

    @FindBy(xpath = "//span[@class = 'title-city-text']")
     WebElement resultLabel;

    @FindBy(xpath = "//ul[@class='tabs cf col']//button/span[2]")
    WebElement navBarItems;

    @FindBy(css = "#tab-vacation-rental-tab-hp")
    WebElement vacationsRentalTab;

    @FindBy(css = "#hotel-destination-hp-vacationRental")
    WebElement vacationGoingToField;

    @FindBy(css = "#hotel-checkin-hp-vacationRental")
    WebElement vacationCheckInField;

    @FindBy(css = "#hotel-checkout-hp-vacationRental")
    WebElement vacationCheckOutField;

    @FindBy(xpath = "//div[@class='cols-nested']//button[@type='submit']")
    WebElement vacationSearchButton;

    @FindBy(xpath = "//a[contains(text(),'Flights to New York')]")
    WebElement flightsToNewYorkLink;

    @FindBy(xpath = "//section[@class='segmented-list toggle open']//a[@class='toggle-trigger open']")
    WebElement exploreMoreToggle;

    @FindBy(css = "#primary-header-car")
    WebElement carTab;

    @FindBy(css = "#primary-header-cruise")
    WebElement cruisesLink;

    @FindBy(css = "#primary-header-deals")
    WebElement dealsLink;

    @FindBy(css = "#primary-header-flight")
    WebElement flightsLink;

    @FindBy(css = "#primary-header-hotel")
    WebElement hotelsLink;

    @FindBy(xpath = "//a[@id='primary-header-activity']")
    WebElement thingsTodoLink;

    public List<String> getNavBarTexts(){
        List<WebElement> navitems;
        navitems = driver.findElements(By.xpath("//ul[@class='tabs cf col']//button/span[2]"));
        List<String> list = new ArrayList<String>();
        for (WebElement we: navitems) {
            list.add(we.getText());
        }
        return list;
    }

    //Actions
    public void TravelorsTabclick(){
        System.out.println("travelors tab expected: "+TravelersTab.getAttribute("id")+" actual: "+TravelersTab.getAttribute("id"));
        TravelersTab.click();}

    public String getDestinationLabelText(){
        return resultLabel.getText();
    }

    public void getHomePageTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations");
    }

    public void validateExpediaLogo(){
       boolean display = ExpediaLogo.isDisplayed();
        Assert.assertEquals(display,true);
    }

    public void showHeroBannerImgSrc(){
        String style = HeroBanner.getAttribute("style");
        String result = style.substring(0,style.lastIndexOf(':'));
        Assert.assertTrue(!result.equals(null));

    }

    public void isHeroBannerDisplayed(){
        boolean result = HeroBanner.isDisplayed();
        Assert.assertTrue(result,"Banner is not Displayed");
    }
    public void searchRoundTripFlightOneAdult(String from, String destination,String departing, String returning) throws InterruptedException {
        FlightOnlyTab.click();
        Thread.sleep(900);
        RoundTripButton.click();
        Thread.sleep(900);
        FlyFromField.sendKeys(from);
        Thread.sleep(900);
        FlyingToField.sendKeys(destination);
        Thread.sleep(900);
        DepartingField.sendKeys(departing);
        Thread.sleep(900);
        ReturningField.sendKeys(returning);
        FlightOnlySearchButton.click();
        Thread.sleep(900);
        Assert.assertEquals(getDestinationLabelText(),"Select your departure to "+destination);

    }

    public void discoverySearchTest(){
        DiscoverButton.click();
        DiscoverSearchBox.sendKeys("Hawaii Hotels", Keys.ENTER);
        List<WebElement> resultcollection = driver.findElements(By.xpath("//a[contains(text(),"+"Hawaii Hotels"+")]"));
        int size = resultcollection.size();
        Assert.assertEquals(size,5);
    }

    public void clickOnVacationRentalTab(){
        clickOnWebElement(vacationsRentalTab);
    }

    public  void typeOnVacationGoingToField(String str){
        typeOnWebElement(vacationGoingToField,str);
    }

    public void typeOnVacationCheckingInField(String str){
        typeOnWebElement(vacationCheckInField,str);
    }

    public void typeOnVacationCheckingOutField(String str){
        typeOnWebElement(vacationCheckOutField,str);
    }

    public void clickOnVacationSearchButton(){
        clickOnWebElement(vacationSearchButton);
    }

    public void properUrl(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.expedia.com/");
    }

    public void hotelLinksIndexValue(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='featured-hotel']//ul[@class='cf']//a"));
        String firstIndexText = list.get(0).getText();
        Assert.assertEquals(firstIndexText,"Sydney Hotels");
    }

    public void flightsToNewYorkLinkStatus(){
        flightsToNewYorkLink.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        String flightsToNewYorkLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'lite-title')]"))).getText();
        Assert.assertTrue(flightsToNewYorkLabel.contains("Flights to New York"));
    }

    public void vacationPakagesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='popular-vacation-destinations']//ul[@class='cf']//a"));
        int size = list.size();
        Assert.assertTrue(size == 12);
    }

    public void exploreMoreToggleVisibility(){
        WebDriverWait wait = new WebDriverWait(driver,2);
        WebElement exploreMoreDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='exploreMore']")));
        exploreMoreToggle.click();
        boolean visible = exploreMoreDiv.isDisplayed();
        Assert.assertFalse(visible);
    }

    public CarsPage clickCarsLink(){
        carTab.click();
        return new CarsPage();
    }

    public CruisesPage clickCruisesLink(){
        cruisesLink.click();
        return new CruisesPage();
    }

    public FlightsPage clickFlightsLink(){
        flightsLink.click();
        return new FlightsPage();
    }

    public DealsPage clickDealsPage(){
        dealsLink.click();
        return new DealsPage();
    }

    public HotelsPage clickHotelsPage(){
        hotelsLink.click();
        return new HotelsPage();
    }

    public ThingsToDoPage clickThingsToDoPage(){
        thingsTodoLink.click();
        return  new ThingsToDoPage();
    }
}

