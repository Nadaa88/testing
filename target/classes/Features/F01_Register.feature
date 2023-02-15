@smoke
Feature: F01_Register | users could register with new accounts
   Scenario: guest user could register with valid data successfully
      Given user goes to the register page
      When user selects a gender type
      And user enters first name "automation" and last name "tester"
      And user enters date of birth
      And user enters email
      And user enters "P@ssw0rd" password and confirm password
      And user clicks on the register button
      Then account is created successfully
