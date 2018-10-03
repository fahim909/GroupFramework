package Tests.testKeywordDriven;

import Pages.HomePage;
import TestData.ExcelReader2;
import TestData.XSSFDataReader;
import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class KeywordDrivenHomePageTest extends CommonAPI {
    HomePage homePage;
    XSSFDataReader xssfDataReader;
    String path = "/Users/junedalam/Documents/July2018WebAutomation/Expedia/src/test/java/Tests/TestFiles/KeyWordDrivenSheet.xlsx";

    @BeforeMethod
    public void createObjects() throws Exception {
        this.homePage = new HomePage();
        this.xssfDataReader = new XSSFDataReader();
        this.xssfDataReader.setExcelFile(path,"Sheet1");
    }

    @Test
    public void verifyPageTitle() throws Exception {
       for (int i = 1; i<6;i++){
           String sActionKeyword = xssfDataReader.getCellData(i, 1);
           switch (sActionKeyword) {
               case "goToRentals":
                   homePage.clickOnVacationRentalTab();
                   break;
               case "typeOnGoingToField":
                   homePage.typeOnVacationGoingToField("Toronto");
                   break;
               case "typeOnCheckingInField":
                   homePage.typeOnVacationCheckingInField("10/10/2018");
                   break;
               case "typeOnCheckingOutField":
                   homePage.typeOnVacationCheckingOutField("10/24/2018");
                   break;
               case "clickOnSearchButton":
                   homePage.clickOnVacationSearchButton();
                   break;
               default:
                   break;
           }
       }
       Thread.sleep(5000);
        String title = driver.getTitle();
        boolean validTitle = driver.getTitle().contains("Hotel Search Results");
        Assert.assertTrue(validTitle);
    }
  }

