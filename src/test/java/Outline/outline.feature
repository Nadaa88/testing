@smoke
 Feature: Scenario Outline:
   Scenario Outline: Login functionality for a social networking site.
     Given user navigates to Facebook
     When I enter Username as "<username>" and Password as "<password>"
     Then login should be unsuccessful
     Examples:
       | username | password |
       | Test1 | Pass1 |
       | Test2 | Pass2 |
       | Test3 | Pass3 |
