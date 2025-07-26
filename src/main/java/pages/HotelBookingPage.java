package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPage {
    WebDriver driver;

    public HotelBookingPage(WebDriver driver) {
        this.driver = driver;
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

    By message = By.name("message"); // textarea

    By submitBtn = By.id("submit");

    // Actions
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

    public String getDisplayedPrice() {
        return driver.findElement(priceText).getText(); // Adjust as per actual ID
    }
}