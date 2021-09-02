package utils;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EyesUtils {
    private Eyes eyes;

    public EyesUtils(Eyes eyes) {
        this.eyes = eyes;
    }

    public void validateWindow(WebDriver driver, String appName, String testName) {
        eyes.open(driver,appName,testName);
        //eyes.setMatchLevel(MatchLevel.EXACT); // pixel by pixel check
        //eyes.setMatchLevel(MatchLevel.CONTENT); // ignore colors
        eyes.setMatchLevel(MatchLevel.STRICT); // default config
        eyes.checkWindow();
        eyes.close();
    }

    public void validateDynamicContent(WebDriver driver, String appName, String testName) {
        eyes.open(driver,appName,testName);
        eyes.setMatchLevel(MatchLevel.LAYOUT); // default config
        eyes.checkWindow();
        eyes.close();
    }

    public void validateLargeContent(WebDriver driver, String appName, String testName) {
        eyes.open(driver,appName,testName);
        eyes.setForceFullPageScreenshot(true); // take full screenshot
        eyes.checkWindow();
        eyes.close();
    }

    public void validateElement(WebDriver driver, By locator, String appName, String testName) {
        eyes.open(driver,appName,testName);
        eyes.checkElement(locator);
        //eyes.checkFrame("frame-bottom");
        eyes.close();
    }
}
