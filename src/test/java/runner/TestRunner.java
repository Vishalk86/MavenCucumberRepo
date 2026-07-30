package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        dryRun = false,
        monochrome = true,
        publish = true,
//        plugin = {"pretty", "html:target/cucumber-report.html"}
      	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}