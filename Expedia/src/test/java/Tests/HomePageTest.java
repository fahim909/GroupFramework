package Tests;

import Pages.HomePage;
import TestData.ExcelReader2;
import base.CommonAPI;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
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
    public void ValidateHeroBannerImgUrl(){
        String result = homePage.ShowHeroBannerImgSrc().substring(0,homePage.ShowHeroBannerImgSrc().lastIndexOf(':'));
        Assert.assertEquals(result,"background-image: url(\"https://tpc.googlesyndication.com/pagead/imgad?id=CICAgKCbm6LR1gEQARgBMgjZMTZt8LM5zQ\"); background-position","Image URL does not match");
    }

    @Test(priority = 1)
    public void ValidateHeroBannerDisplayed(){
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
        public void TestDiscoverSearchButton(){
        homePage.DiscoverySearchTest("Hawaii");
    }

    @Test()
    public void testRoundTripFlightWithOneAdult() throws InterruptedException {
        homePage.searchRoundTripFlightOneAdult("new york","Toronto","10/10/18","10/20/18");
        //Assert.assertEquals(homePage.getDestinationLabelText(),"Select your departure to "+"Toronto");
    }

}
