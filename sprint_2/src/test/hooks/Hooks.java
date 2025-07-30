package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.DriverFactory;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {

        driver = DriverFactory.getDriver();
       
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
    
    
}
