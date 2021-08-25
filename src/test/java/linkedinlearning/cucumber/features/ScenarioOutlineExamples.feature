Feature: Final Bill Calculation

  @ScenarioOutlineExample
  Scenario Outline: Customer bill amount calculation
    Given I have a Customer
    And User enters initial bill amount as <InitialBillAmount>
    When Sales Tax Rate is <TaxRate>
    Then Final bill amount calculated is <CalculatedBillAmount>
    Examples:
    |InitialBillAmount|TaxRate|CalculatedBillAmount|
    |100              |10     |110                 |
    |200              |8      |216                 |
    |100              |1.55   |101.55              |

  @Selenium
  Scenario Outline: Selenium Example
    Given I am in the Formy Home Page
    And I go to the "Complete Web Form" page
    When I provide all the user data "<UserData>"
    Then I get a confirmation alert
    Examples:
      |UserData|
      |Jhon,Smith,Dev,College,Male,2-4|
      |Sara,Connor,Qa,Grad School,Female,5-9|
      |Michele,Thomson,PM,High School,Prefer not to say,10+|