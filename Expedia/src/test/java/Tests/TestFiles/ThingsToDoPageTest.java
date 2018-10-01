package Tests.TestFiles;

import Pages.ThingsToDoPage;
import base.CommonAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class ThingsToDoPageTest extends CommonAPI {

    ThingsToDoPage thingsToDoPage;

    @BeforeMethod
    public void createObject(){
      thingsToDoPage = new ThingsToDoPage();
    }

    @Test
    public void testThingsToDoForm(){
        thingsToDoPage.fillThingsToDoForm("Toronto","10/05/18","10/10/18");
    }

}
