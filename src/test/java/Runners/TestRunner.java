package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Feature/HotelBooking.feature",
        glue = {"stepDefinition", "hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"},
        monochrome =true,
        dryRun=false
     
)

public class TestRunner extends AbstractTestNGCucumberTests{

}
