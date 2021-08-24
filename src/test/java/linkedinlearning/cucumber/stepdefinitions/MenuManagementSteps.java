package linkedinlearning.cucumber.stepdefinitions;

import io.cucumber.java.en.*;
import linkedinlearning.cucumber.RestaurantMenu;
import linkedinlearning.cucumber.RestaurantMenuItem;

public class MenuManagementSteps {
    RestaurantMenu locationMenu = new RestaurantMenu();
    RestaurantMenuItem NewMenuItem;

    @Given("I have a menu item with name {string} and price {int}")
    public void i_have_a_menu_item_with_name_and_price(String newMenuItemName, Integer price) {
        NewMenuItem = new RestaurantMenuItem(newMenuItemName, newMenuItemName, price);
    }

    @When("I add that menu item")
    public void i_add_that_menu_item() {
        locationMenu.addMenuItem(NewMenuItem);
    }

    @Then("Menu Item with name {string} should be added")
    public void menu_item_with_name_should_be_added(String string) {
        System.out.println(locationMenu);
    }
}
