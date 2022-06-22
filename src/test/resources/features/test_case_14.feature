@test_case_14
Feature: TC14_Place Order: Register while Checkout

  Scenario: TC_14_Place Order: Register while Checkout
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When Add products to cart
    And click cart button
    Then verify that cart page is displayed
    When click to Proceed to Checkout on cart web page
    And click on signup_login button
    Then verify New User Signup is visible
    When enter name and email address
    And click signup button
    Then verify ENTER ACCOUNT INFORMATION is visible
    When fill the details, title, name, email, password, date of birth
    And select checkbox sign up for our newsletter
    And fill the details first name, last name, company, address, address2, country, state, city, zipcode, mobile number
    And click create account button
    Then verify that ACCOUNT CREATED is visible
    When click Continue button
    Then verify that Logged in as username is visible
    When click cart button
    And  click proceed to checkout button
    Then verify Address Details and Review Your Order
    When enter description in comment text area and click Place Order
    And enter payment details:Name on Card, Card Number, CVC, Expiration Date
    And click Pay and Confirm Order button
    Then verify success message Your order has been placed successfully
    When click Delete Account button
    Then verify that ACCOUNT DELETED is visible
    And click after delete Continue button


