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
import reporting.TestLogger;

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
}
