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
    public void verifyHumanOrRobotPageTitleTest(){
    signUpPage.verifyHumanOrRobotPageTitle();
}
}
