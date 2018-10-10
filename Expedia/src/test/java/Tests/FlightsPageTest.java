package Tests;

import Pages.FlightsPage;
import Pages.HomePage;
import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FlightsPageTest extends CommonAPI {

    FlightsPage flightsPage;
    HomePage homePage;
    @BeforeMethod
    public void setup(){
        homePage = new HomePage();
        flightsPage = homePage.clickFlightsLink();
    }

    @Test
    public void properUrlTest(){
       flightsPage.properUrl();
    }

    @Test
    public void pageTitleValidationTest(){
       flightsPage.pageTitleValidation();
    }

    @Test
    public void flightslinkIsUnderlinedTest(){
        flightsPage.flightslinkIsUnderlined();
    }

    @Test
    public void headerLabelTextValidationTest(){
        flightsPage.headerLabelTextValidation();
    }

    @Test
    public void dropDownValidationTest(){
        flightsPage.dropDownValidation();
    }

    @Test
    public void airlinesDropDownTest(){
        flightsPage.airlinesDropDown();
    }

    @Test
    public void addOnAdvantageImgUrlValidationTest(){
        flightsPage.addOnAdvantageImgUrlValidation();
    }

    @Test
    public void popularFlightsNDiscountAirfareLabelVisibilityTest(){
        flightsPage.popularFlightsNDiscountAirfareLabelVisibility();
    }

    @Test
    public void popularFlightRoutesLabelVisibilityTest(){
      flightsPage.popularFlightRoutesLabelVisibility();
    }

    @Test
    public void discountAirfareLinksCountTest(){
       flightsPage.discountAirfareLinksCount();
    }

    @Test
    public void popularFlightRoutesLinksCountTest(){
        flightsPage.popularFlightRoutesLinksCount();
    }
}
