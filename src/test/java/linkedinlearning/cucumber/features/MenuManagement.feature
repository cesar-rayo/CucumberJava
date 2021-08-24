@MenuManagementTest
Feature: Menu Management

  @SmokeTest
  Scenario: Add a menu item
    Given I have a menu item with name "Cucumber Sandwich" and price $20
    When I add that menu item
    Then Menu Item with name "Cucumber Sandwich" should be added

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