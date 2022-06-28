@test_case_12 @ui
Feature: TC12_Add products in cart

  Scenario: TC_12_Add products in cart
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click on Products button
    And hover over first product and click Add to cart
    And click Continue Shopping button
    And Hover over second product and click Add to cart
    And click View Cart button
    Then verify both products are added to Cart
    And verify their prices, quantity and total price