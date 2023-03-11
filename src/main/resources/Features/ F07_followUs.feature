
@smoke
Feature: F07_followUs | users could open followUs links

  Scenario: User opens Facebook link
    Given the user is on the website homepage
    When the user clicks on the Facebook link
    Then a new tab should open
    And the Facebook page "https://www.facebook.com/nopCommerce" should be displayed

  Scenario: User opens Twitter link
    Given the user is on the website homepage
    When the user clicks on the Twitter link
    Then a new tab should open
    And the Twitter page "https://twitter.com/nopCommerce" should be displayed

  Scenario: User opens RSS link
    Given the user is on the website homepage
    When the user clicks on the RSS link
    Then a new tab should open
    And the RSS page "https://demo.nopcommerce.com/new-online-store-is-open" should be displayed

  Scenario: User opens YouTube link
    Given the user is on the website homepage
    When the user clicks on the YouTube link
    Then a new tab should open
    And the YouTube page "https://www.youtube.com/user/nopCommerce" should be displayed