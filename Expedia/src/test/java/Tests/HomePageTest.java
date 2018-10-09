package Tests;

import Pages.HomePage;
import TestData.ExcelReader2;
import base.CommonAPI;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import reporting.ExtentManager;

import java.util.List;

public class HomePageTest extends CommonAPI {

    HomePage homePage;
    ExtentReports report;


@BeforeMethod
public void createTestObj(){

    this.homePage = new HomePage();
    report = ExtentManager.getInstance();

}
    @Test(priority = 1)
        public void homePageTitleTest(){
        homePage.getHomePageTitle();
    }
    @Test(priority = 2)
      public void isLogoVisibleTest(){
        homePage.validateExpediaLogo();
    }
    @Test
    public void validateHeroBannerImgUrl(){
       homePage.showHeroBannerImgSrc();
    }
    @Test(priority = 1)
    public void validateHeroBannerDisplayed(){
        homePage.isHeroBannerDisplayed();
    }
    @Test(priority = 4)
    public void addPassengersTest(){
        homePage.TravelorsTabclick();
        for (int i =0;i<5;i++){
            homePage.AdultsPLusOneclick();
        }
    }
    @Test(priority = 5)
        public void testDiscoverSearchButton(){
        homePage.discoverySearchTest();
    }
    @Test()
    public void testRoundTripFlightWithOneAdult() throws InterruptedException {
        homePage.searchRoundTripFlightOneAdult("new york","Toronto","10/10/18","10/20/18");
    }
    @Test
    public void pageUrlTest(){
    homePage.properUrl();
    }

    @Test
    public void hotelLinksIndexValueTest(){
        homePage.hotelLinksIndexValue();
    }

    @Test
    public void flightsToNewYorkLinkStatusTest(){
       homePage.flightsToNewYorkLinkStatus();
    }

    @Test
    public void vacationPakagesCountTest(){
        homePage.vacationPakagesCount();
    }

    @Test
    public void exploreMoreToggleVisibilityTest(){
        homePage.exploreMoreToggleVisibility();
    }
}
