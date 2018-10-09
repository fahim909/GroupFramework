package Pages;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CruisesPage extends CommonAPI {

    public CruisesPage(){
        PageFactory.initElements(driver,this);
    }


    //actions
    public void pageTitleValidate(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Cruises: Find Cheap Cruise Deals & Last Minute Cruises | Expedia");
    }

    public void properUrl(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.expedia.com/Cruises");
    }
}
