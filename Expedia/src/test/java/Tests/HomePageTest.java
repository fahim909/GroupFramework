package Tests;

import Pages.HomePage;
import TestData.ExcelReader2;
import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends CommonAPI {

    HomePage homePage;

@BeforeMethod
public void createTestObj(){
        this.homePage = new HomePage();
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

}
