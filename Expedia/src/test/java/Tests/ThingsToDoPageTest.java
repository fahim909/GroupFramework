package Tests;

import Pages.ThingsToDoPage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.PublicKey;

public class ThingsToDoPageTest extends CommonAPI {

    ThingsToDoPage thingsToDoPage;

    @BeforeMethod
    public void createObject(){
      thingsToDoPage = new ThingsToDoPage();
    }

//    @Test
//    public void testThingsToDoForm(){
//        thingsToDoPage.fillThingsToDoForm("Toronto","10/23/18","10/30/18");
//    }
//
//    @Test
//    public void pageUrl(){
//        thingsToDoPage.properUrl();
//    }
//
//    @Test
//    public void pageTitleTest(){
//        thingsToDoPage.pageTitleValidation();
//    }
//
     @Test
    public void invalidSearchTest() throws IOException {
        thingsToDoPage.fillSearchFormWithInvalidDate();
     }
}
