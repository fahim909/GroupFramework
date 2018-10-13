package Tests;

import Pages.CarsPage;
import Pages.HomePage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarsPageTest extends CommonAPI {
    HomePage homePage;
    CarsPage carsPage;

   @BeforeMethod
    public void setup(){
       homePage = new HomePage();
       carsPage = homePage.clickCarsLink();
   }
   @Test
    public void testCarTabIsUnderLined(){
       carsPage.carTabIsUnderLined();
   }
   @Test
    public void testCarPageBannerIsDisplayed(){
       carsPage.carPageBannerIsDisplayed();
   }
    @Test
    public void testCarPageBannerValidText(){
        carsPage.carPageBannerValidText();
    }
    @Test
    public void testcarTabIsSelected(){
       carsPage.carTabIsSelected();
    }
    @Test
    public void testCarHotelTabIsSelected() throws InterruptedException {
        carsPage.carHotelTabIsSelected();
    }
    @Test
    public void testCarHotelFlightTabIsSelected(){
        carsPage.carHotelFlightTabIsSelected();
    }
    @Test
    public void testCarFlightTabIsSelected(){
        carsPage.carFlightTabIsSelected();
    }
    @Test
    public void testTitleValidation(){
       carsPage.titleValidation();
    }
    @Test
    public void testCheckboxSelection(){
       carsPage.checkboxSelection();
    }
    @Test
    public void testDomesticRentalsLabelFont(){
       carsPage.domesticRentalsLabelVisible();
    }
    @Test
    public void testInternationalRentalCarsHeight(){
       carsPage.internationalRentalCarsLineHeight();
    }
    @Test
    public void testDomesticRentalsListCount(){
       carsPage.domesticRentalsListCount();
    }
    @Test
    public void testInternationalRentalsListCount(){
       carsPage.internationalRentalsListCount();
    }
    @Test
    public void testPageUrl() {
        carsPage.properUrl();
    }
}
