package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CommonFunctions 
{

    WebDriver driver;
    XMLReader xmlReader;

    public CommonFunctions(WebDriver driver) 
    {
        this.driver = driver;
        xmlReader = new XMLReader();
    }
    
    public String getObjectLocator(String objectName) 
    {
        String[] arr = objectName.split("##");
        String moduleName = arr[0];
        String objectKey = arr[1];
        return xmlReader.getLocator(moduleName, objectKey);        
    }

    public void openApplication(String url) 
    {
        driver.get(url);
    }
    
    public void navigateTo(String url) 
    {
        driver.navigate().to(url);
    }
    
    public void openApplicationAs(String value)
    {
    	    driver.get(value);
    }

    public void enter(String objectName, String value) 
    {
        String xpath = getObjectLocator(objectName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.sendKeys(value);
    }

    public void click(String objectName) 
    {
        String xpath = getObjectLocator(objectName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
    }
    
    public String getText(String objectName)
    {
    	    String xpath = getObjectLocator(objectName);
		return driver.findElement(By.xpath(xpath)).getText().trim();    	
    }
    
    public void tabHandling(String value)
    {
       int i = Integer.parseInt(value); 	
    	   ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
    	   driver.switchTo().window(tab.get(i));
    }

    public void waitForElementPresent(String objectName) 
    {
        String xpath = getObjectLocator(objectName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    
    public void selectDate(String objectName, String value) throws Exception
    {
    	    String xpath = getObjectLocator(objectName);
    	    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.click();
        
        String[] arr = value.split("##");
        String date = arr[0];
        String month = arr[1];
        String year = arr[2];
              	  
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-icon-button__icon'])[1]")).click();       
     	 
     	
        List <WebElement> ComingMonth = driver.findElements(By.xpath("//ul[@class='oxd-calendar-dropdown']/li"));
        for(WebElement e:ComingMonth)
        {
        	  String comingDropDownMonth = e.getText();
        	  if(month.equals(comingDropDownMonth))
        	  {
        		  e.click();
        	  }
        	  else
        	  {
        		  continue;
        	  }
        }
        
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-icon-button__icon'])[2]")).click();
        List <WebElement> ComingYear = driver.findElements(By.xpath("//ul[@class='oxd-calendar-dropdown']/li"));
        for(WebElement e:ComingYear)
        {
        	  String comingDropDownYear = e.getText();
        	  if(year.equals(comingDropDownYear))
        	  {
        		  e.click();
        	  }
        	  else
        	  {
        		  continue;
        	  }
        }        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='oxd-calendar-dates-grid']/div/div[normalize-space()='"+date+"']")).click();
    }
}
