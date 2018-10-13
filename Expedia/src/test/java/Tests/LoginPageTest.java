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

    @BeforeMethod
    public void createTestObj(){
        loginPage = new LoginPage();
    }

    @Test
    public void validateUrlTest(){
        loginPage.validateUrl();
    }

    @Test(priority = 1)
    public void isLabelVisibleTest(){
      loginPage.isLabelVisible();
    }
    @Test(priority = 2)
    public void validateLoginFormLabelTest(){
        loginPage.validateLoginFormLabel();
    }
    @Test
    public void testLoginForm(){
        loginPage.loginValidation();
    }

}
