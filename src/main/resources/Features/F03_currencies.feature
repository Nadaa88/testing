
Feature: Verify Currency symbol on Home page

  Scenario: Verify Euro currency symbol on Home page
    Given I am on the home page
    When I select "Euro" currency from the dropdown list on the top left
    Then I should see the Euro Symbol (€) displayed on the products in the home page