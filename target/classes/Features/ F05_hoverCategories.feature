@smoke
Feature: Verify sliders on home page
Scenario: Verify the functionality of home page sliders
Given User is on the home page of nopCommerce website
When User clicks on the first slider
Then User should be redirected to https://demo.nopcommerce.com/nokia-lumia-1020


When User clicks on the second slider
Then User should be redirected to https://demo.nopcommerce.com/iphone-6
