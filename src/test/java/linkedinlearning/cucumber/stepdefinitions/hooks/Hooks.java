package linkedinlearning.cucumber.stepdefinitions.hooks;

import com.applitools.eyes.selenium.Eyes;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.TestContext;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks extends TestContext {
    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before("@Selenium")
    public void initializeDriver(Scenario sc) {
        String driverFlavor = System.getProperty("BROWSER", "firefox");
        initializeEyes();
        try {
            switch (driverFlavor.toLowerCase()) {
                case "firefox":
                    testContext.driver = new RemoteWebDriver(new URL(testContext.gridUrl), new FirefoxOptions());
                    break;
                case "edge":
                    testContext.driver = new RemoteWebDriver(new URL(testContext.gridUrl), new EdgeOptions());
                    break;
                case "opera":
                    testContext.driver = new RemoteWebDriver(new URL(testContext.gridUrl), new OperaOptions());
                    break;
                default:
                    testContext.driver = new RemoteWebDriver(new URL(testContext.gridUrl), new ChromeOptions());
                    break;
            }
            testContext.driver.manage().deleteAllCookies();
            testContext.driver.manage().window().maximize();
            testContext.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL " + gridUrl);
        }
    }

    private void initializeEyes() {
        testContext.eyes = new Eyes();
        testContext.eyes.setApiKey(System.getProperty("applitools.api.key"));
        System.out.println("Apikey length: "+System.getProperty("applitools.api.key").length());
    }

    @Before("@SmokeTest")
    public void beforeSmokeTestMessage(Scenario sc) {
        System.out.println(String.format(">> Before Smoke Test method '%s'", sc.getName()));
    }

    @Before
    public void beforeDisplayMessage(Scenario sc) {
        System.out.println(String.format(">> Before method '%s'", sc.getName()));
    }

    @After
    public void afterDisplayMessage(Scenario sc) {
        System.out.println(String.format(">> After method '%s'", sc.getName()));
    }

    @After("@Selenium")
    public void closeDriver() {
        testContext.driver.quit();
        testContext.eyes.abortIfNotClosed();
    }
}
