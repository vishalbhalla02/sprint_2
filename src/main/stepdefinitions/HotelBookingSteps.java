package stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import pages.HotelBookingPage;
import io.cucumber.java.en.*;

public class HotelBookingSteps {

    
    HotelBookingPage hotelBookingPage = new HotelBookingPage();

    @Given("the user is on the hotel booking page")
    public void the_user_is_on_the_hotel_booking_page() {
        hotelBookingPage.openPage();
    }

    @When("the user enters booking details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_booking_details(
            String firstName, String lastName, String email, String phone, 
            String roomType, String guests, String checkIn, String checkOut, 
            String pickup, String rating, String location, String message) {

        hotelBookingPage.fillBookingForm(
            firstName, lastName, email, phone,
            roomType, guests, checkIn, checkOut,
            rating, location, message,
            pickup.equalsIgnoreCase("yes")
        );
    }


    @When("submits the booking form")
    public void submits_the_booking_form() {
        hotelBookingPage.submitForm();
    }

    @Then("the booking should be successful")
    public void the_booking_should_be_successful() {
        assertTrue(hotelBookingPage.verifySuccessMessage(),"Success message was not displayed");
    }
}
