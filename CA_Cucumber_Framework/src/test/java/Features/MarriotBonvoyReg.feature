@UATTesting
Feature: Marriot Bonvoy login validation
Scenario: login validation with valid data
Given initialize browser
When User go to sign in or join option
Then User click on join option
Then User fill the require text
Then User successfully register 
