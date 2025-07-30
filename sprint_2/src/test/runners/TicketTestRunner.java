package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/features/ticketBooking.feature",
    glue = {"stepdefinitions.ticket","hooks"},
    plugin = {"pretty", "html:reports/hotel-report.html"},
    monochrome = true,
    dryRun=false
)
public class TicketTestRunner extends AbstractTestNGCucumberTests {
}
