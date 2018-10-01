package Tests;

import Pages.RecentSearchesPage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
