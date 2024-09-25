Feature: login test

  Scenario Outline: testing the successful login
    Given the user is on the serenity demo page
    When attempts to log in
      | user   | pass   |
      | <user> | <pass> |
    Then validate the text on screen <message>
    Examples:
      | user          | pass         | message  |
      | standard_user | sauce_secret | PRODUCTS |
