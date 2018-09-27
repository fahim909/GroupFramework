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
    List<String> navbarItems;

    @BeforeMethod
    public void createTestObj() throws Exception {
        this.homePage = new HomePage();
        this.connectToSqlDB = new ConnectToSqlDB();
        searchList = connectToSqlDB.readDataBase("navbarlinks","links");
        this.navbarItems = homePage.getNavBarTexts();

    }

    @Test
    public void navbarLinksTest(){
        for (int i = 0; i <searchList.size()-1;i++){
            Assert.assertTrue(searchList.get(i).contains(navbarItems.get(i).substring(0,navbarItems.get(i).indexOf("\nTab"))));
        }
    }

}
