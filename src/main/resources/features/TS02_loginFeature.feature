@smoke
Feature: 2-Login - user can login successfully with valid credentials

  Scenario: user logins with valid credentials
    Given user clicks on login button
    When user enters valid "automationtest@gmail.com" and "lamiaa123"
    And user hits login
    Then user logins successfully and redirected to home page


  Scenario: user logins with invalid credentials
    Given user clicks on login button
    When user enters invalid "test@invalid.com" and "invalid"
    And user hits login
    Then user cannot login to the account