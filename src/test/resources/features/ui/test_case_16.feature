@test_case_16 @ui
Feature: TC16_Place Order: Login before Checkout

  Scenario: TC_16_Place Order: Login before Checkout
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    And click on signup_login button
    And enter correct email and password
    And click login button
    Then verify that Logged in as username is visible
    When Add products to cart
    And click cart button after adding products on home page
    Then verify that cart page is displayed
    When click to Proceed to Checkout on cart web page
    Then verify Address Details and Review Your Order
    When enter description in comment text area and click Place Order
    And enter payment details:Name on Card, Card Number, CVC, Expiration Date
    And click Pay and Confirm Order button
    Then verify success message Your order has been placed successfully
    Then verify that Order Placed! is visible
    Then click on Continue on payment done page
    When click Delete Account button
    Then verify that ACCOUNT DELETED is visible
    And click after delete Continue button


