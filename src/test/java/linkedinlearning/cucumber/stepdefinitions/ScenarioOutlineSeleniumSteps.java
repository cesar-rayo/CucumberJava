package linkedinlearning.cucumber.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.FormPage;
import pages.FormyHomePage;
import pages.ThanksPage;
import utils.TestContext;
import utils.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class ScenarioOutlineSeleniumSteps extends TestContext {
    private final TestContext testContext;
    private User user;
    private FormyHomePage homePage;

    public ScenarioOutlineSeleniumSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am in the Formy Home Page")
    public void i_am_in_the_formy_home_page() {
        homePage = new FormyHomePage(testContext.driver);
    }

    @Given("I go to the {string} page")
    public void i_go_to_the_page(String pageName) {
        switch (pageName) {
            case "Complete Web Form":
                homePage.clickFormLink();
                break;
            default: throw new IllegalArgumentException("Option not supported!");
        }
    }

    @When("I provide all the user data {string}")
    public void i_provide_all_the_user_data(String userData) {
        var formPage = new FormPage(testContext.driver);

        user = new User(userData.split(","));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String dateFormatted = dtf.format(now.plusMonths(1));

        formPage.typeFirstName(user.getFirstName());
        formPage.typeLastName(user.getLastName());
        formPage.typeJobTitle(user.getJobTitle());
        formPage.selectYearsByVisibleText(user.getExperience());
        formPage.typeDate(dateFormatted);

        formPage.clickSubmit();
    }

    @Then("I get a confirmation alert")
    public void i_get_a_confirmation_alert() {
        var thanksPage = new ThanksPage(testContext.driver);
        String expectedMessage = "The form was successfully submitted!";
        assertEquals("The confirmation message does not match", expectedMessage, thanksPage.getConfirmationMsg());
    }
}
