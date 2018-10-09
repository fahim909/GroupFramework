package Tests;

import Pages.HomePage;
import TestData.ExcelReader2;
import base.CommonAPI;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import reporting.ExtentManager;

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
        String title = homePage.getHomePageTitle();
        Assert.assertEquals(title,"Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations");
    }
    @Test(priority = 2)
      public void isLogoVisibleTest(){
        //boolean result=homePage.ValidateExpediaLogo();
        //Assert.assertEquals(result,true);
          System.out.println(homePage.ValidateExpediaLogo());
    }
    @Test
    public void validateHeroBannerImgUrl(){
        String result = homePage.ShowHeroBannerImgSrc().substring(0,homePage.ShowHeroBannerImgSrc().lastIndexOf(':'));
        Assert.assertTrue(!result.equals(null));
    }
    @Test(priority = 1)
    public void validateHeroBannerDisplayed(){
        boolean result = homePage.isHeroBannerDisplayed();
        Assert.assertTrue(result,"Banner is not Displayed");
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
        int size = homePage.DiscoverySearchTest("Hawaii Hotels");
      Assert.assertEquals(size,5);
    }
    @Test(priority = 5)
    public void testDiscoverSearchButton2(){
        int size = homePage.DiscoverySearchTest("Amsterdam Hotels");
        Assert.assertEquals(size,6);
    }
    @Test()
    public void testRoundTripFlightWithOneAdult() throws InterruptedException {
        homePage.searchRoundTripFlightOneAdult("new york","Toronto","10/10/18","10/20/18");
        //Assert.assertEquals(homePage.getDestinationLabelText(),"Select your departure to "+"Toronto");
    }
    @Test
    public void pageUrlTest(){
    homePage.properUrl();
    }
}
