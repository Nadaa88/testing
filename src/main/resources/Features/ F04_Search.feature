@smoke
Feature: Search functionality in e-commerce website

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
    Given user is on the home page of the website
    When user searches for product with sku "<sku>"
    Then search shows relevant results
    And URL contains "https://demo.nopcommerce.com/search?q="
    And click on the product in search result
    And verify the sku of the product is "<sku>"

    Examples:
      | sku |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |




