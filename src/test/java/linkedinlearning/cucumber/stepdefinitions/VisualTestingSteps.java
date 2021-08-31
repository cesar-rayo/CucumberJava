package linkedinlearning.cucumber.stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BookHomePage;
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
        eyesUtils.validateWindow(testContext.driver, "Books Store", "iSearchForTheTitle");
        System.out.println("List of visible books: " + bookHomePage.countBooks());
        assertTrue(String.format("The title '%s' is not visible", title),bookHomePage.isBookVisible(title));
    }
}
