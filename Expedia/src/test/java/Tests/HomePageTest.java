package Tests;

import Pages.HomePage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends CommonAPI {

    HomePage homePage;
    @BeforeMethod
            public void initialize() {
         homePage = new HomePage(driver);
    }
    @Test
    public void SearchFlightOnlyTab(){

    }
}
