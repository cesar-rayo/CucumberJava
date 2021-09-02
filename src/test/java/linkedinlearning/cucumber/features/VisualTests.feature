@VisualTest @Selenium
Feature: Visual Validations
  Scenario: Perform visual testing
    Given I am in the books store home page
    When I search for the title "Agile Testing"
    Then the book with title "Agile Testing" is visible

  Scenario: Perform visual testing layout
    Given I am in the-internet home page
    When I click the dynamic content link
    Then the dynamic content loads

  Scenario: Perform visual testing large page
    Given I am in the-internet home page
    When I click the large content link
    Then the Large page loads