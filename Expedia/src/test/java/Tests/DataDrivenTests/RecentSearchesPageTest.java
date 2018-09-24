package Tests.DataDrivenTests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RecentSearchesPage;
import base.CommonAPI;
import databases.ConnectToSqlDB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RecentSearchesPageTest extends CommonAPI {
    HomePage homePage;
    ConnectToSqlDB connectToSqlDB;
    List<String> searchList = new ArrayList<String>();
    List<WebElement> navbarItems;

    @BeforeMethod
    public void createTestObj() throws Exception {
        this.homePage = new HomePage();
        this.connectToSqlDB = new ConnectToSqlDB();
        this.navbarItems = homePage.getNavBarTexts();

    }

    @Test
    public void navbarLinksTest(){
        for (int i = 0; i <searchList.size();i++){
            Assert.assertEquals(searchList.get(i),navbarItems.get(i).getText());
        }
    }

}
