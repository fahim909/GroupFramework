package Tests;

import Pages.DataBaseHomePage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class DataBaseHomePageTest extends CommonAPI {
    DataBaseHomePage dataBaseHomePage;

    public DataBaseHomePageTest() throws Exception {
    }
    @BeforeMethod
    public void createTestObj() throws Exception {
        this.dataBaseHomePage = new DataBaseHomePage();
    }
    @Test
    public void navbarLinksTest(){
        dataBaseHomePage.compareDBLinks();
    }

}
