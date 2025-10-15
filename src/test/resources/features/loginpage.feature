@login
Feature: Login to Demo Sauce site and view Products page
Given I am on the Sauce Demo login page
When I enter valid credentials (standard_user / secret_sauce) and click Login
Then I am taken to the Products page

  @smoke
  Scenario Outline: User login to Sauce demo and view the products page
    Given the user is on the login page
    When the user logs in with "<userName>" and "<password>"
    Then the user should land on the list of products page
    Examples:
      | userName       | password       |
      | valid_username | valid_password |

  Scenario Outline: User displayed with an error when invalid credentials entered
    Given the user is on the login page
    When the user logs in with "<userName>" and "<password>"
    Then the user should see the "<errorMessage>"
    Examples:
      | userName         | password         | errorMessage                                                              |
      | invalid_username | invalid_password | Epic sadface: Username and password do not match any user in this service |
      | locked_username  | locked_password  | Epic sadface: Sorry, this user has been locked out.                       |
