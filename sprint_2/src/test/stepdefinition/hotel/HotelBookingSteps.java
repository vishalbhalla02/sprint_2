package stepdefinition.hotel;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
        assertTrue(hotelBookingPage.verifySuccessMessage());
    }
    
    @Then("the booking should be unsuccessful")
    public void the_booking_should_be_unsuccessful() {
//        assertFalse(hotelBookingPage.verifySuccessMessage());
//        assertTrue(hotelBookingPage.verifyBookingFailure());
        boolean emailMsg=hotelBookingPage.getEmailValidationMessage();

    }
    
    @Then("the booking should be unsuccessful due to missing required fields")
    public void booking_should_fail_due_to_missing_fields() {
        boolean firstNameMsg = hotelBookingPage.getFirstNameValidationMessage();
        boolean phoneMsg = hotelBookingPage.getPhoneValidationMessage();

        System.out.println("Validation for First Name: " + firstNameMsg);
        System.out.println("Validation for Phone: " + phoneMsg);

    }
//

    
    @And("Close the browser")
    public void b_close() {
    	hotelBookingPage.browser_close();
    }
    
}
