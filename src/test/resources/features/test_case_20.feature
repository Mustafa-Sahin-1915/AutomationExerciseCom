@test_case_20
Feature: TC_20:View & Cart Brand Products

  Scenario: TC_20:View & Cart Brand Products
    Given user launches browser
    And navigate to url
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    When enter product name in search input and click search button
    Then verify that SEARCHED PRODUCTS is visible
    And verify that all products related to search are visible
    When add all searched products to cart
    Then click cart button on home page
    Then verify that all searched products added into cart
    And click signup button on home page
    Then enter correct email and password
    And click login button
    And verify that Logged in as username is visible
    And click cart button on home page
    Then verify that all searched products added into cart after login as well

