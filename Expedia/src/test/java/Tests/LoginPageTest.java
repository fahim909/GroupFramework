package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonAPI {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void createTestObj(){
        loginPage = new LoginPage();
    }

    @Test
    public void alidateUrl(){
        Assert.assertEquals(loginPage.returnUrl(),"https://www.expedia.com/user/signin");
    }
    @Test(priority = 1)
    public void isLabelVisible(){
        boolean result = loginPage.isLabelDisplayed();
        Assert.assertEquals(result,true);
    }
    @Test(priority = 2)
    public void validateLoginFormLabel(){
        if(loginPage.isLabelDisplayed()){
            String Label = loginPage.returnlabelText();
            Assert.assertEquals(Label,"Sign in with your email");
        }

    }
    @Test
    public void testLoginForm(){
        loginPage.loginValidation();
    }

}
