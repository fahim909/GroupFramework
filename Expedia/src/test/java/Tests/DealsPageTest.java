package Tests;

import Pages.DealsPage;
import Pages.HomePage;
import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DealsPageTest extends CommonAPI {
    HomePage homePage;
    DealsPage dealsPage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
        this.dealsPage = homePage.clickDealsPage();
    }

    @Test
    public void properUrlTest() {
     dealsPage.properUrl();
    }

    @Test
    public void pageTitleValidationTest(){
        dealsPage.pageTitleValidation();
    }

    @Test
    public void dealsLinkIsUnderlinedTest(){
        dealsPage.dealsLinkIsUnderlined();
    }

    @Test
    public void headerLabelTextValidationTest(){
        dealsPage.headerLabelTextValidation();
    }

    @Test
    public void chooseClassVerificationTest(){
        dealsPage.chooseClassVerification();
    }

    @Test
    public void hawaiiLinkValidationTest() throws InterruptedException {
        dealsPage.hawaiiLinkValidation();
    }

    @Test
    public void skiLinkValidationTest() throws InterruptedException {
        dealsPage.skiLinkValidation();
    }

    @Test
    public void vacationPakageDealsLabelFontWeightTest() {
        dealsPage.vacationPakageDealsLabelFontWeight();
    }

    @Test
    public void hotelDealsLabelcolorTest(){
        dealsPage.hotelDealsLabelcolor();
    }

    @Test
    public void flightDealsDisplayTest(){
        dealsPage.flightDealsDisplay();
    }

    @Test
    public void cruiseLabelBoxsizeTest(){
       dealsPage.cruiseLabelBoxsize();
    }

    @Test
    public void carRentalDealsLabelVisibilityTest(){
       dealsPage.carRentalDealsLabelVisibility();
    }

    @Test
    public void vacationDealsCountTest(){
       dealsPage.vacationDealsCount();
    }

    @Test
    public void hotelsDealsCountTest(){
        dealsPage.hotelsDealsCount();
    }

    @Test
    public void flightDealsCountTest(){
        dealsPage.flightDealsCount();
    }

    @Test
    public void cruiseDealsCountTest(){
        dealsPage.cruiseDealsCount();
    }

    @Test
    public void carRentalDealsCountTest(){
        dealsPage.carRentalDealsCount();
    }
}
