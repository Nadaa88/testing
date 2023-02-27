@smoke
Feature: Select and click a random sub-category from a main category

  Scenario: Hover over a main category and click a random sub-category
    Given the user is on the Home page
    When the user selects a random main category
    And the user hovers over the selected main category
    And the user selects a random sub-category from the hovered main category
    Then the user is redirected to the sub-category page
    And the sub-category page title should match the selected sub-category text
