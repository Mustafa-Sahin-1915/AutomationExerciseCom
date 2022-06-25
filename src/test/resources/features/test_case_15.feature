@test_case_15
Feature: TC14_Place Order: Register before Checkout

  Scenario: TC_15_Place Order: Register before Checkout
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    And click on signup_login button
    Then verify New User Signup is visible
    When enter name and email address
    And click signup button
    When fill the details, title, name, email, password, date of birth
    And select checkbox sign up for our newsletter
    And fill the details first name, last name, company, address, address2, country, state, city, zipcode, mobile number
    And click create account button
    Then verify that ACCOUNT CREATED is visible
    When click Continue button
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


