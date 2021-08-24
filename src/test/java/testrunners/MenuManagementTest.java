package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/linkedinlearning/cucumber/features/MenuManagement.feature"},
        glue = {"linkedinlearning/cucumber/stepdefinitions"},
        // logical operators: 'and', 'or', not
        tags = "not (@NightlyBuildTest and @RegularTest)",
        plugin = {"pretty"}
)
public class MenuManagementTest {
}
