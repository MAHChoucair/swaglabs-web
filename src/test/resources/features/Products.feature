@PRODUCTS
Feature: Add products to cart

  Background: Login
    Given the user is on the SwagLabs page
    And attempts to log in
      | user          | pass         |
      | standard_user | secret_sauce |

  @Happy_Producto
  Scenario: Add a product to the shopping cart
    When decide to buy the product 'Sauce Labs Fleece Jacket'
    Then should see my selected product in the shopping cart

  @Alterno_Producto
  Scenario: Remove a product from the shopping cart
    And decide to buy the product 'Sauce Labs Backpack'
    When remove the product from the cart
    Then should see the shopping cart should be empty