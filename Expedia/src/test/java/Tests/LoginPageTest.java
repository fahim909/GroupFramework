package Tests;

import Pages.LoginPage;
import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

    LoginPage loginPage;

    @BeforeMethod
    public void createTestObj(){
        loginPage = new LoginPage();
    }



    @Test
    public void ValidateUrl(){
        Assert.assertEquals(loginPage.returnUrl(),"https://www.expedia.com/user/signin?ckoflag=0");
    }

    @Test(priority = 1)
    public void isLabelVisible(){
        boolean result = loginPage.isLabelDisplayed();
        Assert.assertEquals(result,true);
    }

    @Test(priority = 2)
    public void ValidateLoginFormLabel(){
        if(loginPage.isLabelDisplayed()){
            String Label = loginPage.returnlabelText();
            Assert.assertEquals(Label,"Sign in with your email");
        }

    }

    @Test
    public void testLoginForm(){
        loginPage.typeEmail("lowang22@gmail.com");
        loginPage.typePassword("selenium4life");
        loginPage.clickSubmitBUtton();
    }

}
