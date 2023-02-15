@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: user could login with valid email and password
    Given user go to login page
    When user login with valid email "test@example.com" and "P@ssw0rd"
    And user press on login button
    Then user logs in to the system successfully
  Scenario: user could login with invalid email and password
    Given user verify to login page
    When user login with invalid email "wrong@example.com" and "P@ssw0rd"
    And user clicks on login button
    Then user could not log in to the system



