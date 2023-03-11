@smoke
Feature: Wishlist functionality

  Scenario: Add product to wishlist
    Given the user is on the homepage
    When the user clicks on the wishlist button for "HTC One M8 Android L 5.0 Lollipop"
    Then a success message with a green background color should be displayed
    And the success message should contain the text "The product has been added to your wishlist"
    And the success message background color should be green


  Scenario: Add product to wishlist and verify the quantity
    Given User is on the home page
    When User clicks on the wishlist button of "HTC One M8 Android L 5.0 Lollipop" product
    Then User waits for the success message to disappear and clicks on the Wishlist tab
    And User verifies that the Qty value is greater than 0
