package linkedinlearning.cucumber.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.TestContext;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hook extends TestContext {
    private final TestContext testContext;

    public Hook(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before("@Selenium")
    public void initializeDriver() {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.operaBlink();
        try {
            testContext.driver = new RemoteWebDriver(new URL(testContext.gridUrl), desiredCapabilities);
            testContext.driver.manage().deleteAllCookies();
            testContext.driver.manage().window().maximize();
            testContext.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL " + gridUrl);
        }
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
    }
}
