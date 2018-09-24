package Pages;

import base.CommonAPI;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecentSearchesPage extends CommonAPI {

    public RecentSearchesPage() {

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



}
