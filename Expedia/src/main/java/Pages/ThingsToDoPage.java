package Pages;

import base.CommonAPI;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static TestData.GoogleSheetReader.getSheetsService;

public class ThingsToDoPage extends CommonAPI {

    public ThingsToDoPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='activity-destination-alp']")
    WebElement destinationInput;
    @FindBy(xpath = "//input[@id='activity-start-alp']")
    WebElement startDateinput;
    @FindBy(xpath = "//input[@id='activity-end-alp']")
    WebElement endDateInput;
    @FindBy(xpath = "//label[@class='col search-btn-col']//button[@type='submit']")
    WebElement searchButton;
    @FindBy(xpath = "//h1[@class='wizard-tabs launch-page-title']")
    WebElement searchThingsToDoLabel;
    @FindBy(xpath = "//h3[contains(text(),'US Activities')]")
    WebElement usActivitiesLabel;
    @FindBy(xpath = "//h3[contains(text(),'Things To Do in Europe')]")
    WebElement thingsToDoInEuropeLabel;
    @FindBy(xpath = "//h3[contains(text(),'What to Do in the Caribbean')]")
    WebElement whatToDoInTheCaribbeanLabel;
    @FindBy(xpath = "//h3[contains(text(),'Tours and Activities in Latin America')]")
    WebElement toursAndActivitiesInLatinAmericaLabel;
    @FindBy(xpath = "//a[@id='primary-header-activity']")
    WebElement thingsTodoLink;

    // actions
    public void fillThingsToDoForm(String destination, String start, String end){
        typeOnWebElement(destinationInput,destination);
        typeOnWebElement(startDateinput,start);
        typeOnWebElement(endDateInput,end);
        clickOnWebElement(searchButton);
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(destination));
    }

    public void properUrl(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.expedia.com/Activities");
    }

    public void pageTitleValidation(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Things To Do Near Me: Find Fun Activities Nearby | Expedia");
    }

    public void thingsToDoLlinkIsUnderlined(){
        String borderProp = thingsTodoLink.getCssValue("border-bottom");
        Assert.assertTrue(borderProp.contains("solid"));
    }

    public List<List<Object>> getSpreadSheetRecords(String spreadsheetId, String range) throws IOException {
        Sheets service = getSheetsService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            return null;
        } else {
            return values;
        }
    }
    public void fillSearchFormWithInvalidDate() throws IOException {
        String spreadsheetId ="1X2JWa5Xsr5KfiaowH3C77819nmv59elg48QamKcnj68";
        String range= "Sheet1!A2:C";
        List<List<Object>> col2Value = getSpreadSheetRecords(spreadsheetId, range);
        for (List row : col2Value) {

            typeOnWebElement(destinationInput,row.get(0).toString());
            typeOnWebElement(startDateinput,row.get(1).toString());
            typeOnWebElement(endDateInput,row.get(2).toString());
            clickOnWebElement(searchButton);
        }
        WebDriverWait wait = new WebDriverWait(driver,3);
        WebElement incorrect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='alert-title no-outline']")));
        Assert.assertTrue(incorrect.isDisplayed());
    }

    public void headerLabelTextValidation(){
        String text = searchThingsToDoLabel.getText();
        Assert.assertTrue(text.contains("Search Things To Do"));
    }

    public void dropDownValidation(){
        driver.findElement(By.xpath("//div[contains(@class,'col forms')]//span[@class='icon icon-toggle180']")).click();
        WebDriverWait wait = new WebDriverWait(driver,3);
        WebElement incorrect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mer-email")));
        boolean visible = driver.findElement(By.cssSelector("#mer-email")).isDisplayed();
        Assert.assertTrue(visible);
    }

    public void usActivitiesLabelVisibility(){
        Assert.assertTrue(usActivitiesLabel.isDisplayed());
    }

    public void thingsToDoInEuropeLabelVisibility(){
        Assert.assertTrue(thingsToDoInEuropeLabel.isDisplayed());
    }

    public void whatToDoInTheCaribbeanLabelVisibiity(){
        Assert.assertTrue(whatToDoInTheCaribbeanLabel.isDisplayed());
    }

    public void toursAndActivitiesInLatinAmericaLabelVisibility(){
        Assert.assertTrue(toursAndActivitiesInLatinAmericaLabel.isDisplayed());
    }

    public void usActivitiesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div[1]//div[1]//ul[1]/li"));
        Assert.assertEquals(list.size(),8);
    }

    public void europeActivitiesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div[2]//div[1]//ul[1]/li"));
        Assert.assertEquals(list.size(),8);
    }

    public void caribbeanActivitiesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div[3]//div[1]//ul[1]/li"));
        Assert.assertEquals(list.size(),8);
    }

    public void latinActivitiesCount(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='launch-seo']//div[4]//div[1]//ul[1]/li"));
        Assert.assertEquals(list.size(),8);
    }
}
