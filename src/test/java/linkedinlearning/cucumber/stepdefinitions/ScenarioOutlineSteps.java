package linkedinlearning.cucumber.stepdefinitions;

import io.cucumber.java.en.*;
import linkedinlearning.cucumber.BillCalculationHelper;

import static org.junit.Assert.assertTrue;

public class ScenarioOutlineSteps {
    int initialBillAmount;
    double taxRate;

    @Given("I have a Customer")
    public void i_have_a_customer() {

    }

    @Given("User enters initial bill amount as {int}")
    public void user_enters_initial_bill_amount_as(Integer initialAmount) {
        initialBillAmount = initialAmount;
    }

    @When("Sales Tax Rate is {double}")
    public void sales_tax_rate_is(Double taxRate) {
        this.taxRate = taxRate;
    }

    @Then("Final bill amount calculated is {double}")
    public void final_bill_amount_calculate_is(Double expectedValue) {
        double actualAmount = BillCalculationHelper.calculateBillForCustomer(initialBillAmount, taxRate);
        assertTrue("The calculated total does not match!",expectedValue == actualAmount);
    }
}
