@VisualTest @Selenium
Feature: Visual Validations
  Scenario: Perform visual testing
    Given I am in the books store home page
    When I search for the title "Agile Testing"
    Then the book with title "Agile Testing" is visible

  Scenario: Perform visual testing layout
    Given I am in the dynamic content from the-internet
    Then the dynamic content loads