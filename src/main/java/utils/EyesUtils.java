package utils;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;

public class EyesUtils {
    private Eyes eyes;

    public EyesUtils(Eyes eyes) {
        this.eyes = eyes;
    }

    public void validateWindow(WebDriver driver, String appName, String testName) {
        eyes.open(driver,appName,testName);
        eyes.checkWindow();
        eyes.close();
    }
}
