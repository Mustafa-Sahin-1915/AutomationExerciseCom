@test_case_17 @ui
Feature: TC_17:Remove Products From Cart

  Scenario: TC_17:Remove Products From Cart
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When Add products to cart
    And click cart button after adding products on home page
    Then verify that cart page is displayed
    And click X button corresponding to particular product on view cart page
    Then verify that product is removed from the cart on view cart page


