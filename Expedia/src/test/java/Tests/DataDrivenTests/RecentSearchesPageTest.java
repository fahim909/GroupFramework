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
    RecentSearchesPage recentSearchesPage;

    public RecentSearchesPageTest() throws Exception {
    }


    @BeforeMethod
    public void createTestObj() throws Exception {
        this.recentSearchesPage = new RecentSearchesPage();
    }

    @Test
    public void navbarLinksTest(){
        recentSearchesPage.compareDBLinks();
    }

}
