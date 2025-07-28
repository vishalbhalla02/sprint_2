package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/features/ticketBooking.feature",
    glue = "stepdefinitions.ticket"
)
public class TicketTestRunner extends AbstractTestNGCucumberTests {
}
