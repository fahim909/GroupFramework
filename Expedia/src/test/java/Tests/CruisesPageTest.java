package Tests;

import Pages.CruisesPage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CruisesPageTest extends CommonAPI {

    CruisesPage cruisesPage;

    @BeforeMethod
    public void setup(){
        cruisesPage = new CruisesPage();
    }
    @Test
    public void pageTitleValidateTest(){
        cruisesPage.pageTitleValidate();
    }
    @Test
    public void pageUrlTest(){
        cruisesPage.properUrl();
    }

}
