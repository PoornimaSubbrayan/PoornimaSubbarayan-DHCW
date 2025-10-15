@products
Feature: Products to be sorted and displayed in ascending order based on price
Given I am on the Products page
When I select Price (low to high) from the sort dropdown
Then products are displayed in ascending order by price
#Item Order Verification
When I check the prices of all visible products
Then each product’s price is greater than or equal to the previous one
 #Negative Case
When I sort by Price (low to high)
Then all items remain visible, and no lower-priced item is missing

  Background: User logs into Sauce demo application
    Given the user is on the login page
    When the user logs in with "valid_username" and "valid_password"
    Then the user should land on the list of products page

  @itemorderverification
  Scenario: User is able to sort the products based on the price low to high option
    Given the user is on the products page
    When the user selects the Price low to high from the sort dropdown
    Then the products should be displayed in ascending order by price

  @negative
  Scenario: User is able to see the same products count if sort by price low to high and no lower priced item is missing
    Given the user is on the products page and count the products
    When the user selects the Price low to high from the sort dropdown
    Then the product count should remain the same


