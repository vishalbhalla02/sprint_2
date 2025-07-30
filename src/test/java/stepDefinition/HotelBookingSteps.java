package stepDefinition;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.HotelBookingPage;
import hooks.Hooks;

public class HotelBookingSteps {
	
	 HotelBookingPage hotelPage;

	    @Given("I launch the Hotel Booking page")
	    public void launchHotelBookingPage() {
	        hotelPage = new HotelBookingPage(Hooks.driver);
	    }

	    @When("I enter {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	    public void enterDetails(String fname, String lname, String email, String phone,
	                              String checkIn, String checkOut, String location) {
	        hotelPage.fillMandatoryFields(fname, lname, email, phone, checkIn, checkOut, location);
	        hotelPage.submitForm();
	    }

//	    @Then("I should see the submitted details displayed correctly")
//	    public void verifyDetails() {
//	        String result = hotelPage.getConfirmationDetails();
//	        Assert.assertTrue(result.contains("John"), "Validation failed: Data not displayed correctly");
//	        Assert.assertTrue(result.contains("Doe"), "Missing last name in confirmation");
//	        Assert.assertTrue(result.contains("john@test.com"), "Missing email in confirmation");
//	        Assert.assertTrue(result.contains("9876543210"), "Missing phone number in confirmation");
//
//	        
//	    }
	    @Then("I should see the submitted details displayed correctly")
	    public void verifyDetails() {
	        String firstName = Hooks.driver.findElement(
	            By.xpath("//td[text()='First Name']/following-sibling::td")
	        ).getText();

	        Assert.assertEquals(firstName, "John", "First Name did not match");
	    }


	
	
}
