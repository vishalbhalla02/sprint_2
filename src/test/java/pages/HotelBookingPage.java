package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class HotelBookingPage {



	    private WebDriver driver;

	    private By firstName = By.id("firstName");
	    private By lastName = By.id("lastName");
	    private By email = By.id("email");
	    private By phone = By.id("phone");
	    private By roomType = By.name("Room Type");
	    private By guestCount = By.id("guest");
	    private By checkInDate = By.id("checkIn");
	    private By checkOutDate = By.id("checkOut");
	    private By freePickupYes = By.id("yes");
	    private By rating = By.id("rating"); 
	    private By location = By.name("location"); 
	    private By message = By.id("message");
	    private By submitBtn = By.id("submit");
	    private By outputDiv = By.id("output");

	    public HotelBookingPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void fillMandatoryFields(String fname, String lname, String mail, String phoneNum,
	                                     String checkIn, String checkOut, String loc) {
	        driver.findElement(firstName).sendKeys(fname);
	        driver.findElement(lastName).sendKeys(lname);
	        driver.findElement(email).sendKeys(mail);
	        driver.findElement(phone).sendKeys(phoneNum);
	        driver.findElement(checkInDate).sendKeys(checkIn);
	        driver.findElement(checkOutDate).sendKeys(checkOut);

	        Select selectLocation = new Select(driver.findElement(location));
	        selectLocation.selectByVisibleText(loc);
	    }

	    public void submitForm() {
	        driver.findElement(submitBtn).click();
	    }

	    public String getConfirmationDetails() {
	        WaitUtils.waitForElementVisible(driver, outputDiv, 5);
	        return driver.findElement(outputDiv).getText();
	    }
//	    public String getConfirmationDetails() {
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        WebElement confirmationTable = wait.until(
//	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='output1']//table"))
//	        );
//	        return confirmationTable.getText(); // returns entire table text
//	    }


		
	}

