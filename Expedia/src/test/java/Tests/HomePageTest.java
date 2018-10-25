package Tests;

import Pages.HomePage;
import TestData.ExcelReader;
import TestData.XSSFDataReader;
import base.CommonAPI;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.Assert;
import org.testng.annotations.*;
import reporting.ExtentManager;

public class HomePageTest extends CommonAPI {

    HomePage homePage;
    ExtentReports report;
    XSSFDataReader xssfDataReader;
    String path = "/Users/junedalam/Documents/July2018WebAutomation/Expedia/src/test/java/Tests/TestFiles/KeyWordDrivenSheet.xlsx";

@BeforeMethod
public void createTestObj() throws Exception {
    this.xssfDataReader = new XSSFDataReader();
    this.xssfDataReader.setExcelFile(path,"Sheet1");
    this.homePage = new HomePage();
    report = ExtentManager.getInstance();
}
    @Test(priority = 1)
        public void homePageTitleTest(){
        homePage.getHomePageTitle();
    }
    @Test(priority = 2)
      public void isLogoVisibleTest(){
        homePage.validateExpediaLogo();
    }
    @Test
    public void validateHeroBannerImgUrl(){
       homePage.showHeroBannerImgSrc();
    }
    @Test(priority = 1)
    public void validateHeroBannerDisplayed(){
        homePage.isHeroBannerDisplayed();
    }
    @Test(priority = 4)
    public void addPassengersTest(){
        homePage.TravelorsTabclick();
        for (int i =0;i<5;i++){
            homePage.AdultsPLusOneclick();
        }
    }
    @Test(priority = 5)
        public void testDiscoverSearchButton(){
        homePage.discoverySearchTest();
    }
    @Test()
    public void testRoundTripFlightWithOneAdult() throws InterruptedException {
        homePage.searchRoundTripFlightOneAdult("new york","Toronto","10/10/18","10/20/18");
    }
    @Test
    public void pageUrlTest(){
    homePage.properUrl();
    }

    @Test
    public void hotelLinksIndexValueTest(){
        homePage.hotelLinksIndexValue();
    }

    @Test
    public void flightsToNewYorkLinkStatusTest(){
       homePage.flightsToNewYorkLinkStatus();
    }

    @Test
    public void vacationPakagesCountTest(){
        homePage.vacationPakagesCount();
    }

    @Test
    public void exploreMoreToggleVisibilityTest(){
        homePage.exploreMoreToggleVisibility();
    }

    @DataProvider
    public Object[][] getExcelTestData(){
        Object data[][] = ExcelReader.getTestData(0);
        return data;
    }
    @Test(dataProvider = "getExcelTestData")
    public void testRoundTripFlightWithExcelData(String from, String to, String departing, String returning) throws InterruptedException {
        homePage.searchRoundTripFlightOneAdult(from,to,departing,returning);
    }
    @Test
    public void verifyPageTitleWithKeyWord() throws Exception {
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
                    homePage.typeOnVacationCheckingInField("10/20/2018");
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
