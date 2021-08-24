package linkedinlearning.cucumber.stepdefinitions;

import io.cucumber.java.en.*;
import linkedinlearning.cucumber.RestaurantMenu;
import linkedinlearning.cucumber.RestaurantMenuItem;

import static org.junit.Assert.assertEquals;

public class MenuManagementSteps {
    RestaurantMenu locationMenu = new RestaurantMenu();
    RestaurantMenuItem NewMenuItem;
    String actualErrorMessage = "";

    public MenuManagementSteps() {
        System.out.println(">>> Constructor called");
    }

    // Using regex to make the char $ optional
    @Given("I have a menu item with name {string} and price ([$]*){int}")
    public void i_have_a_menu_item_with_name_and_price(String newMenuItemName, Integer price) {
        NewMenuItem = new RestaurantMenuItem(newMenuItemName, newMenuItemName, price);
    }

    @When("I add that menu item")
    public void i_add_that_menu_item() {
        try {
            locationMenu.addMenuItem(NewMenuItem);
        } catch (IllegalArgumentException e) {
            actualErrorMessage = e.getMessage();
        }
    }

    @Then("Menu Item with name {string} should be added")
    public void menu_item_with_name_should_be_added(String string) {
        System.out.println(locationMenu);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedError) {
        assertEquals("The error message does not match", actualErrorMessage, expectedError);
    }
}
