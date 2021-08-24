@MenuManagementTest
Feature: Menu Management
  Background: Add one item
    Given I have a menu item with name "Egg Salad" and price $10
    When I add that menu item
    Then Menu Item with name "Egg Salad" should be added

  @SmokeTest
  Scenario: Add a menu item
    Given I have a menu item with name "Cucumber Sandwich" and price $20
    When I add that menu item
    Then Menu Item with name "Cucumber Sandwich" should be added

  @DuplicatedItemTest @SmokeTest
  Scenario: Add a duplicated item
    Given I have a menu item with name "Egg Salad" and price $10
    When I add that menu item
    Then I should see an error message "Duplicated Item!"

  @RegularTest
  Scenario: Add a menu item without $ char
    Given I have a menu item with name "Cucumber Salad" and price 15
    When I add that menu item
    Then Menu Item with name "Cucumber Salad" should be added

  @NightlyBuildTest @RegularTest
  Scenario: Add a third menu item without $ char
    Given I have a menu item with name "Chicken Sandwich" and price 15
    When I add that menu item
    Then Menu Item with name "Chicken Sandwich" should be added
