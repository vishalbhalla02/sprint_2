package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPage {
    WebDriver driver;

    public HotelBookingPage() {
    	driver = new ChromeDriver();
    }
 
    // Locators
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("email");
    By phone = By.id("phone");

    By roomType = By.name("Room Type");
    By guests = By.id("guest");
    By checkIn = By.id("checkIn");
    By checkOut = By.id("checkOut");

    By priceSlider = By.id("mRange"); // may vary; adjust if needed
    By priceText = By.id("demo"); // may vary; placeholder for actual price display

    By pickupYes = By.id("yes"); // adjust if ID is different

    By guestRating = By.name("Rating");
    By location = By.name("location");

    By message = By.id("message"); // textarea

    By submitBtn = By.id("submit");
    By output = By.id("output1");

    // Actions
    public void openPage() {
    	 driver.get("https://webapps.tekstac.com/TicketBooking/HotelBooking.html");
    }
    public void enterFullName(String fname, String lname) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailId) {
        driver.findElement(email).sendKeys(emailId);
    }

    public void enterPhone(String phoneNo) {
        driver.findElement(phone).sendKeys(phoneNo);
    }

    public void selectRoomType(String type) {
        Select dropdown = new Select(driver.findElement(roomType));
        dropdown.selectByVisibleText(type);
    }

    public void enterGuests(String num) {
        driver.findElement(guests).sendKeys(num);
    }

    public void enterCheckInDate(String inDate) {
        driver.findElement(checkIn).sendKeys(inDate);
    }

    public void enterCheckOutDate(String outDate) {
        driver.findElement(checkOut).sendKeys(outDate);
    }

    public void selectGuestRating(String rating) {
        Select dropdown = new Select(driver.findElement(guestRating));
        dropdown.selectByVisibleText(rating);
    }

    public void selectLocation(String loc) {
        Select dropdown = new Select(driver.findElement(location));
        dropdown.selectByVisibleText(loc);
    }

    public void enableFreePickup() {
        driver.findElement(pickupYes).click();
    }

    public void enterMessage(String msg) {
        driver.findElement(message).sendKeys(msg);
    }

    public void submitForm() {
        driver.findElement(submitBtn).click();
    }
    public void fillBookingForm(String fname, String lname, String emailId, String phoneNo, String roomType,
            String guests, String inDate, String outDate, String rating,
            String loc, String msg, boolean freePickup) {
			enterFullName(fname, lname);
			enterEmail(emailId);
			enterPhone(phoneNo);
			selectRoomType(roomType);
			enterGuests(guests);
			enterCheckInDate(inDate);
			enterCheckOutDate(outDate);
			selectGuestRating(rating);
			selectLocation(loc);
			if (freePickup) {
				enableFreePickup();
			}
			enterMessage(msg);
}


    public String getDisplayedPrice() {
        return driver.findElement(priceText).getText(); // Adjust as per actual ID
    }
    
    public boolean verifySuccessMessage() {
    	 return driver.findElement(output).isDisplayed();
    }
}