package Tests;

import Pages.HomePage;
import Pages.SignUpPage;
import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPageTest extends CommonAPI {

SignUpPage signUpPage;

@BeforeMethod
public void createTestObj(){
    signUpPage = new SignUpPage();
}

@Test
    public HomePage TestSignUp(){
signUpPage.typeFirstName("lo");
signUpPage.typeLastName("wang");
signUpPage.typeEmail("lowang22@gmail.com");
signUpPage.typeConfirmPass("lowang22@gmail.com");
signUpPage.ClickAgree();
signUpPage.clickCreateAccountButton();
    return new HomePage();
}

@Test
    public void verifySignUpPageTitle(){
    String title =  driver.getTitle();
    Assert.assertEquals(title,"Create an account");
}


}
