package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HotelBookingPage;
import utils.ExcelReader;
import io.cucumber.java.en.*;
import java.io.IOException;

public class HotelBookingSteps {
    WebDriver driver;
    HotelBookingPage bookingPage;

    @Given("user opens the hotel booking page")
    public void openHotelBookingPage() {
        driver = new ChromeDriver();
        driver.get("https://webapps.tekstac.com/TicketBooking/HotelBooking.html");
        bookingPage = new HotelBookingPage(driver);
    }

    @When("user enters valid hotel booking information")
    public void enterBookingDetails() throws IOException {
        String[] data = ExcelReader.getBookingData("Sheet1");
        bookingPage.fillForm(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
        bookingPage.submitForm();
    }

    @Then("booking details should be displayed successfully")
    public void verifyBookingDetails() {
        assert driver.getPageSource().contains("Booking Details");
        driver.quit();
    }
}
