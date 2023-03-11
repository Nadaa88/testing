@smoke
Feature: Verify first slider on home page

  Scenario: Clicking on first slider should redirect to correct page

    Given user is on the home page of the website
    When user clicks on the first slider
    Then user should be redirected to "https://demo.nopcommerce.com/nokia-lumia-1020" page
    And the page should be fully loaded
