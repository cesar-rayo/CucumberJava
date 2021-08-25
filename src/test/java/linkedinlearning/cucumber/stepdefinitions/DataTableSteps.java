package linkedinlearning.cucumber.stepdefinitions;

import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class DataTableSteps {

    @Given("I placed an order for the following items")
    public void i_placed_an_order_for_the_following_items(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> listOfItems = dataTable.asLists();
        for (List<String> billData: listOfItems) {
            for (String billItem: billData) {
                System.out.println(billItem);
            }
        }
    }

    @Given("I placed an order for the following map of items")
    public void i_placed_an_order_for_a_map_of_items(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> listOfItems = dataTable.asMaps();
        for (Map<String,String> billData: listOfItems) {
            for (Map.Entry<String, String> billItem: billData.entrySet()) {
                System.out.println(String.format("billItem[%s]='%s'",billItem.getKey(),billItem.getValue()));
            }
        }
    }

    @When("I generate the bill")
    public void i_generate_the_bill() {
    }

    @Then("a bill for ${int} should be generated")
    public void a_bill_should_be_generated(Integer total) {
    }
}
