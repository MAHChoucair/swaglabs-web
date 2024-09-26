@LOGIN
Feature: login test

  @Happy_Login
  Scenario Outline: testing the successful login
    Given the user is on the SwagLabs page
    When attempts to log in
      | user   | pass   |
      | <user> | <pass> |
    Then validate the text on screen <message>
    Examples:
      | user          | pass         | message  |
      | standard_user | secret_sauce | Products |

  @Unhappy_Login
  Scenario Outline: testing the unsuccessful login
    Given the user is on the SwagLabs page
    When attempts to log in
      | user   | pass   |
      | <user> | <pass> |
    Then validate error text on screen <message>
    Examples:
      | user            | pass         | message                               |
      | locked_out_user | secret_sauce | Sorry, this user has been locked out. |
      | standard_user   | secret_wrong | Username and password do not match    |
      |                 | secret_sauce | Username is required                  |
