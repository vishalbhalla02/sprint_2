package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WaitUtils {

    public static void waitForElementVisible(WebDriver driver, By locator, int timeoutSec) {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(timeoutSec))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String captureScreenshot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String destPath = "target/screenshots/" + name + ".png";
            Files.createDirectories(Paths.get("target/screenshots/"));
            Files.copy(src.toPath(), Paths.get(destPath));
            return destPath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
