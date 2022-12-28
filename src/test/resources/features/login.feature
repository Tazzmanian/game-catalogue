# This is comment

@SmokeScenario
Feature: Login into account
  Existing user should be able to login to account using correct credentials

@SmokeTest
Scenario: Login into account with correct credentials as admin
  Given User navigates to the application website
  And User clicks on login button
  And User enters a valid username
  And User enters a valid password
  When User clicks on the login button
  Then User should be taken to the default page



#@SmokeTest
#Scenario Outline: Login into account with incorrect credentials as admin
#  Given User navigates to the application website
#  And User clicks on login button
#  And User enters a username
#  And User enters a password
#  When User clicks on the login button with <username> and <password>
#  Then User should be taken to the default page
#  Examples:
#    |username|password|
#    |admin|test|
#    |admin1|test1|