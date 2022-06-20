@test_case_13
Feature: TC13_Verify Product quantity in Cart

  Scenario Outline: TC_13_Verify Product quantity in Cart
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    And click View Product for any product on home page
    And verify product detail is opened
    And increase quantity to <quantity>
    And click Add to cart button
    And click View Cart button
    Then verify that product is displayed in cart page with exact quantity <quantity>

    Examples:
      | quantity |
      | 4        |