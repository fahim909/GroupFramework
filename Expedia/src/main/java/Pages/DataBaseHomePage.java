package Pages;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHomePage extends CommonAPI {
    ConnectToSqlDB connectToSqlDB;
    List<String> searchList = new ArrayList<String>();
    List<String> navbarItems;
    HomePage homePage = new HomePage();

    public DataBaseHomePage() throws Exception {
        this.connectToSqlDB = new ConnectToSqlDB();
        searchList = connectToSqlDB.readDataBase("navbarlinks","links");
        this.navbarItems = homePage.getNavBarTexts();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'See Recent Searches')]")
    WebElement RecentSearchesLink;
    public LoginPage clickRecentSerchesLink(){
        RecentSearchesLink.click();
        driver.findElement(By.xpath("//a[@class='empty-sign-in']")).click();
        return new LoginPage();
    }

    @FindBy(xpath = "//li[@id='flight-group-1']//a[@class='group-header-link']")
    WebElement firstSearchResult;
    public String firstSearchResultText(){
        return firstSearchResult.getText();
    }

    @FindBy(xpath = "//li[@id='flight-group-2']//a[@class='group-header-link']")
    WebElement secondSearchResult;
    public String seconSearchResultText(){
        return secondSearchResult.getText();
    }

    @FindBy(xpath = "//li[@id='flight-group-3']//a[@class='group-header-link']")
    WebElement thirdSearchResult;
    public String thirdSearchResultText(){
        return thirdSearchResult.getText();
    }

    public void compareDBLinks(){
        for (int i = 0; i <searchList.size()-1;i++){
            Assert.assertTrue(searchList.get(i).contains(navbarItems.get(i).substring(0,navbarItems.get(i).indexOf("\nTab"))));
        }
    }
}
