package Tests;

import Pages.CruisesPage;
import Pages.HomePage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CruisesPageTest extends CommonAPI {
    HomePage homePage;
    CruisesPage cruisesPage;

    @BeforeMethod
    public void setup(){
        homePage = new HomePage();
        cruisesPage = homePage.clickCruisesLink();
    }

    @Test
    public void pageTitleValidateTest(){
        cruisesPage.pageTitleValidate();
    }
    @Test
    public void pageUrlTest(){
        cruisesPage.properUrl();
    }
    @Test
    public void headerLabelTextValidationTest(){
        cruisesPage.headerLabelTextValidation();
    }
    @Test
    public void cruisesLinkisUnderLinedTest(){
        cruisesPage.cruisesLinkisUnderLined();
    }
    @Test
    public void yourFirstStopforDiscountCruisesLabelVisibilityTest(){
        cruisesPage.yourFirstStopforDiscountCruisesLabelVisibility();
    }
    @Test
    public void cruiseDealsandDiscountsontheBestCruiseLinesLabelVisibilityTest(){
        cruisesPage.cruiseDealsandDiscountsontheBestCruiseLinesLabelVisibility();
    }
    @Test
    public void enjoytThetBestCruiseTravelDestinationsLabelVisibilityTest(){
        cruisesPage.enjoytThetBestCruiseTravelDestinationsLabelVisibility();
    }
    @Test
    public void lastMinuteCruiseDealsVacationIdeasLabelVisibilityTest(){
        cruisesPage.lastMinuteCruiseDealsVacationIdeasLabelVisibility();
    }
    @Test
    public void takeAVacationonTheseAllInclusiveCruisesLabelVisibilityTest(){
        cruisesPage.takeAVacationonTheseAllInclusiveCruisesLabelVisibility();
    }
    @Test
    public void discountCruisesCountTest(){
        cruisesPage.discountCruisesCount();
    }
    @Test
    public void bestCruisesCountTest(){
        cruisesPage.bestCruisesCount();
    }
    @Test
    public void destinationCruisesCountTest(){
        cruisesPage.destinationCruisesCount();
    }
    @Test
    public void lastMinuteCruisesCountTest(){
        cruisesPage.lastMinuteCruisesCount();
    }
    @Test
    public void allInclusiveCruisesCountTest(){
        cruisesPage.allInclusiveCruisesCount();
    }

}
