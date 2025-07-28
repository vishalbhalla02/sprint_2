package stepdefinitions.ticket;

import io.cucumber.java.en.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TicketBookingPage;

public class TicketBookingSteps {

    private WebDriver driver;
    private TicketBookingPage bookingPage;

    @Before
    public void setUp() {
        
        driver = new ChromeDriver();
        bookingPage = new TicketBookingPage(driver);
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Given("User opens the ticket booking page")
    public void user_opens_ticket_page() {
        bookingPage.openPage();
    }

    @When("the user enters booking details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_booking_details(
            String from, String to, String boarding, String dropping,
            String date, String time, String busType,
            String name, String phone, String gender,
            String country, String address) {

        bookingPage.enterFrom(from);
        bookingPage.enterTo(to);
        bookingPage.enterBoarding(boarding);
        bookingPage.enterDropping(dropping);
        bookingPage.enterDate(date);
        bookingPage.enterTime(time);
        bookingPage.selectBusType(busType);
        bookingPage.enterName(name);
        bookingPage.enterPhone(phone);
        bookingPage.selectGender(gender);
        bookingPage.enterCountry(country);
        bookingPage.enterAddress(address);
    }

    @When("clicks on Submit button")
    public void user_clicks_submit() {
        bookingPage.clickSubmit();
    }

    @Then("the submitted details should be shown in table")
    public void submitted_details_visible() {
        Assert.assertTrue(bookingPage.verifySuccessMessage(), "Success message is not displayed!");
    }
}
