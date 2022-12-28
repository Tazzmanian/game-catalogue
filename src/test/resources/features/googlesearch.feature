@SmokeGoogle
Feature: Test google search functionality

  Scenario: Validate google search
    Given browser is open
    And user is on google page
    When user enters a text in search box
    And hit enter
    Then user is navigated to search results