package utils;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public String gridUrl = "http://localhost:4444/wd/hub";
    public WebDriver driver;
    public Eyes eyes;
}
