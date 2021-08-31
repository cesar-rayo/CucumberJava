package linkedinlearning.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import utils.TestContext;

public class VisualTestingSteps extends TestContext {
    private TestContext testContext;

    @Given("I execute this step")
    public void iExecuteThisStep() {
        testContext.driver.get("file:///Users/crayo/Documents/work/personal/java_projects/CucumberJava/website/index.html");
        System.out.println("Execute Step");
    }
}
