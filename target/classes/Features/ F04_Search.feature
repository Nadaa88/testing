@smoke

Feature: Login functionality for a social networking site.

  Scenario Outline: Login with different username and password
    Given user navigates to Facebook
    When user enter Username as "<username>" and Password as "<password>"
    And user clicks on the login button
    Then login should be unsuccessful

    Examples:
      | username | password |
      | Test1    | Pass1    |
      | Test2    | Pass2    |
      | Test3    | Pass3    |


  Scenario Outline 1: Search using product name
    Given user is on the home page of the website
    When user searches for "<product>"
    Then search shows relevant results
    And URL contains "https://demo.nopcommerce.com/search?q="
    And verify the search results contain the searched product

    Examples:
      | product |
      | book |
      | laptop |
      | nike |

  Scenario Outline 2: Search using sku
    Given user verify to home page of the website
    When user searches for product with sku "<sku>"
    Then search shows relevant results

    Examples:
      | sku |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |





