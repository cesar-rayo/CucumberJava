Feature: Data Tables

  @ListOfStrings
  Scenario: Bill amount generation
    Given I placed an order for the following items
    |Cucumber Sandwich|2|20|
    When I generate the bill
    Then a bill for $40 should be generated

  @ListOfListStrings
  Scenario: Bill amount generation for several items
    Given I placed an order for the following items
      |Cucumber Sandwich|2|20|
      |Cucumber Salad   |1|15|
    When I generate the bill
    Then a bill for $55 should be generated

  @ListOfMaps
  Scenario: Bill amount generation for several items in maps
    Given I placed an order for the following map of items
      |ItemName         |Units|UnitPrice|
      |Cucumber Sandwich|2    |20       |
      |Cucumber Salad   |1    |15       |
      |Egg Salad        |2    |10       |
    When I generate the bill
    Then a bill for $75 should be generated