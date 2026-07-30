package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utilities.BaseClass;
import utilities.CommonFunctions;

public class CommonSteps extends BaseClass 
{
    CommonFunctions cf;
    public static String storedValue;

    @Given("I launch browser")
    public void launchBrowser() 
    {
        setup();
        cf = new CommonFunctions(driver); // New
    }

    @And("I open application")
    public void openApplication() 
    {
        cf.openApplication(config.getProperty("url"));        
    }
    
    @And("I open application as {string}")
    public void openApplicationAs(String value) 
    {
        cf.openApplicationAs(value);
    }
    
    @And("I navigate application as {string}")
    public void navigateApplicationAs(String value) 
    {
        cf.navigateTo(value);
    }

    @When("I enter on {string} as {string}")
    public void enterText(String objectName, String value) 
    {
        cf.enter(objectName, value);
    }

    @And("I click on {string}")
    public void clickElement(String objectName) 
    {
        cf.click(objectName);
    }
    
    @When("I select date {string} as {string}")
    public void selectdate(String objectName, String value) throws Exception
    {
        cf.selectDate(objectName, value);
    }

    @Then("I waitForElementPresent on {string}")
    public void waitForElement(String objectName) 
    {
        cf.waitForElementPresent(objectName);
        //driver.quit();
    }   
    
    
    @When("I store text from {string}")
    public void storeText(String objectName) 
    {
        storedValue = cf.getText(objectName);
        System.out.println("Stored Value = " + storedValue);
    }
    
    @When("I enter stored value in {string}")
    public void enterStoredValue(String objectName) 
    {
        cf.enter(objectName, storedValue);
    }
    
    @And ("I switch to Window as {string}")
    public void switchToWindow (String value)
    {
    	   cf.tabHandling(value);    	   
    }
    
    @AfterStep
    public void addScreenshotsToExtentReport(Scenario scenario)
    {
	    	final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    	scenario.attach(screenshot, "image/png", scenario.getName());    	
    }
    
    
    //===============================================For Testing Only=====================================================
    @And("I go to Table")
    public void Table() 
    {
        List <WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
        System.out.println(rows.size());
        System.out.println("Testing");
        for(WebElement row : rows) 
        {

            if(row.getText().contains("aniket Ashok")) 
            {
                row.findElement(By.xpath(".//button[i[contains(@class,'bi-pencil')]]")).click();
                break;
            }
        }
    }
    
    @And("I get data")
    public void getData() 
    {
        String data = driver.findElement(By.xpath("//div[@class='oxd-table-filter-header-title']")).getText().trim();
      	System.out.println(data);
    }
        
}
