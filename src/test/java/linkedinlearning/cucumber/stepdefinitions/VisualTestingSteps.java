package linkedinlearning.cucumber.stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookHomePage;
import pages.InternetHomePage;
import utils.EyesUtils;
import utils.TestContext;

import static org.junit.Assert.assertTrue;

public class VisualTestingSteps extends TestContext {
    private TestContext testContext;
    private BookHomePage bookHomePage;
    private EyesUtils eyesUtils;

    public VisualTestingSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am in the books store home page")
    public void iExecuteThisStep() {
        bookHomePage = new BookHomePage(testContext.driver);
        eyesUtils = new EyesUtils(testContext.eyes);
    }

    @When("I search for the title {string}")
    public void iSearchForTheTitle(String title) {
        bookHomePage.search(title);
        System.out.println("List of visible books: " + bookHomePage.countBooks());
    }

    @Then("the book with title {string} is visible")
    public void theBookWithTitleIsVisible(String title) {
        String methodName = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
        eyesUtils.validateWindow(testContext.driver, "Books Store", methodName);
        assertTrue(String.format("The title '%s' is not visible", title),bookHomePage.isBookVisible(title));
    }

    @Given("I am in the dynamic content from the-internet")
    public void iAmInTheDynamicContentFromTheInternet() {
        InternetHomePage internetHomePage = new InternetHomePage(testContext.driver);
        eyesUtils = new EyesUtils(testContext.eyes);
    }

    @Then("the dynamic content loads")
    public void theDynamicContentLoads() {
        // Validate dynamic content
        String methodName = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
        eyesUtils.validateDynamicContent(testContext.driver, "The Internet", methodName);
    }
}
