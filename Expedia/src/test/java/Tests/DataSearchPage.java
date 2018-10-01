package Tests;

import Pages.HomePage;
import TestData.ExcelReader2;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSearchPage extends CommonAPI {

    HomePage homePage;

    @BeforeMethod
    public void createTestObj(){
        this.homePage = new HomePage();
    }

    @DataProvider
    public Object[][] getExcelTestData(){
        Object data[][] = ExcelReader2.getTestData(0);
        return data;
    }

    @Test(dataProvider = "getExcelTestData")
    public void testRoundTripFlightWithOneAdult(String from, String to, String departing, String returning) throws InterruptedException {
        homePage.searchRoundTripFlightOneAdult(from,to,departing,returning);
    }


}
