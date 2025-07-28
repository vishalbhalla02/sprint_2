package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TicketBookingPage {
    private WebDriver driver;

    // Constructor: take WebDriver instance (do NOT start it here!)
    public TicketBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By fromInput = By.id("from");
    By toInput = By.id("to");
    By boardingInput = By.id("boarding");
    By droppingInput = By.id("dropping");
    By dateInput = By.id("date");
    By timeInput = By.id("Time");
    By busType = By.id("bus");
    By nameInput = By.id("name");
    By phoneInput = By.id("phone");
    By maleRadio = By.id("male");
    By femaleRadio = By.id("female");
    By otherRadio = By.id("other");
    By countryDropdown = By.id("country");
    By addressInput = By.id("address");
    By submitBtn = By.id("submit");
    By output = By.id("output1");

    public void openPage() {
        driver.get("https://webapps.tekstac.com/TicketBooking/TicketBookingForm.html");
    }

    public void enterFrom(String from) {
        driver.findElement(fromInput).sendKeys(from);
    }

    public void enterTo(String to) {
        driver.findElement(toInput).sendKeys(to);
    }

    public void enterBoarding(String boarding) {
        driver.findElement(boardingInput).sendKeys(boarding);
    }

    public void enterDropping(String dropping) {
        driver.findElement(droppingInput).sendKeys(dropping);
    }

    public void enterDate(String date) {
        driver.findElement(dateInput).sendKeys(date);
    }

    public void enterTime(String time) {
    	Select timeDropdown = new Select(driver.findElement(timeInput));
        timeDropdown.selectByVisibleText(time);
        
    }

    public void selectBusType(String bus) {
        Select busDropdown = new Select(driver.findElement(busType));
        busDropdown.selectByVisibleText(bus);
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void selectGender(String gender) {
        String g = gender.trim().toLowerCase();
        if (g.equals("male")) driver.findElement(maleRadio).click();
        else if (g.equals("female")) driver.findElement(femaleRadio).click();
        else driver.findElement(otherRadio).click();
    }

    public void enterCountry(String country) {
        Select countrySelect = new Select(driver.findElement(countryDropdown));
        countrySelect.selectByVisibleText(country);
    }

    public void enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }

    public boolean verifySuccessMessage() {
        return driver.findElement(output).isDisplayed();
    }
}
