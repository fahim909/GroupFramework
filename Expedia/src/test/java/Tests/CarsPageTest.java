package Tests;

import Pages.CarsPage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarsPageTest extends CommonAPI {

    CarsPage carsPage;

   @BeforeMethod
    public void setup(){
       carsPage = new CarsPage();
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
    public void testCarHotelTabIsSelected(){
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
