package Tests;

import Pages.HomePage;
import Pages.HotelsPage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelsPageTest extends CommonAPI {
    HomePage homePage;
    HotelsPage hotelsPage;

    @BeforeMethod
    public void setup(){
        homePage = new HomePage();
        hotelsPage = homePage.clickHotelsPage();
    }

    @Test()
    public void testValidateLabelHotelDiscount(){
        hotelsPage.validateLabelHotelDiscount();
    }

    @Test()
    public void testValidateLabelEuropeHotel(){
        hotelsPage.validateLabelEuropeHotels();
    }

    @Test()
    public void testValidateLabelInternationalHotel(){
        hotelsPage.validateLabelInternationalHotel();
    }

    @Test
    public void testValidateUsHotelLinkCount(){
        hotelsPage.validateUsHotelLinkCount();
    }
    @Test
    public void testValidateEuropeHotelLinkCount(){
        hotelsPage.validateEuropeHotelLinkCount();
    }
    @Test
    public void testValidateInternationalHotelLinkCount(){
        hotelsPage.validateInternationalHotelLinkCount();
    }

    @Test
    public void testSendButtonBorderRadius(){
        hotelsPage.sendButtonBorderRadius();
    }

    @Test
    public void testAddPropertyButtonColor(){
        hotelsPage.addPropertyButtonColor();
    }

    @Test
    public void testIsQRCodeDisplayed(){
        hotelsPage.isQRCodeDisplayed();
    }

    @Test
    public void testLegalDivText(){
        hotelsPage.legalDivText();
    }

    @Test
    public void testTodaysTopDealBoxSize(){
        hotelsPage.todaysTopDealBoxSize();
    }

    @Test
    public void testExploreMoreAttribute(){
        hotelsPage.exploreMoreAttribute();
    }

    @Test
    public void testTitleValidation(){
        hotelsPage.titleValidation();
    }

    @Test
    public void pageUrlTest(){
        hotelsPage.properUrl();
    }
    @Test
    public void hotelsLinkIsUnderlinedTest(){
        hotelsPage.hotelsLinkIsUnderlined();
    }

    @Test
    public void countGlobalLinksTest(){
        hotelsPage.countGlobalLinks();
    }
}
