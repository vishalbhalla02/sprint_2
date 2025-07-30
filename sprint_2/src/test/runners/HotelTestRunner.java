package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/features/hotelBooking.feature",
    glue = "stepdefinition.hotel",
    plugin = {"pretty", "html:reports/hotel-report.html"},
    monochrome = true,
    dryRun=false
    
)
public class HotelTestRunner extends AbstractTestNGCucumberTests {
}
