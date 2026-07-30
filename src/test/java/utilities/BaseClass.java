package utilities;

import org.openqa.selenium.WebDriver;

public class BaseClass 
{

    public static WebDriver driver;
    public static ConfigReader config;

    public void setup() 
    {
        driver = DriverFactory.initializeDriver();
        config = new ConfigReader();
    }
}
