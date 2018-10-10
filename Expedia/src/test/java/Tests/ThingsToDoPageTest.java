package Tests;

import Pages.HomePage;
import Pages.ThingsToDoPage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.PublicKey;

public class ThingsToDoPageTest extends CommonAPI {
    HomePage homePage;
    ThingsToDoPage thingsToDoPage;

    @BeforeMethod
    public void createObject(){
        homePage = new HomePage();
        thingsToDoPage = homePage.clickThingsToDoPage();
    }

    @Test
    public void testThingsToDoForm(){
        thingsToDoPage.fillThingsToDoForm("Toronto","10/23/18","10/30/18");
    }

    @Test
    public void pageUrl(){
        thingsToDoPage.properUrl();
    }

    @Test
    public void pageTitleTest(){
        thingsToDoPage.pageTitleValidation();
    }

     @Test
    public void invalidSearchTest() throws IOException {
        thingsToDoPage.fillSearchFormWithInvalidDate();
     }

     @Test
    public void headerLabelTextValidationTest(){
        thingsToDoPage.headerLabelTextValidation();
     }

     @Test
    public void usActivitiesLabelVisibilityTest(){
        thingsToDoPage.usActivitiesLabelVisibility();
     }

     @Test
    public void thingsToDoInEuropeLabelVisibilityTest(){
        thingsToDoPage.thingsToDoInEuropeLabelVisibility();
     }

     @Test
    public void whatToDoInTheCaribbeanLabelVisibiityTest(){
        thingsToDoPage.whatToDoInTheCaribbeanLabelVisibiity();
     }

     @Test
    public void toursAndActivitiesInLatinAmericaLabelTest(){
        thingsToDoPage.toursAndActivitiesInLatinAmericaLabelVisibility();
     }

     @Test
    public void usActivitiesCountTest(){
        thingsToDoPage.usActivitiesCount();
     }

     @Test
    public void europeActivitiesCountTest(){
        thingsToDoPage.europeActivitiesCount();
     }

     @Test
    public void caribbeanActivitiesCountTest(){
        thingsToDoPage.caribbeanActivitiesCount();
     }

     @Test
    public void latinActivitiesCountTest(){
        thingsToDoPage.latinActivitiesCount();
     }

     @Test
    public void thingsToDoLlinkIsUnderlinedTest(){
        thingsToDoPage.thingsToDoLlinkIsUnderlined();
     }
}
