@test_case_8 @ui
Feature: TC8_Verify All Products and product detail page

  Scenario: TC_8_Verify All Products and product detail page
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    And the products list is visible
    When click on View Product of first product
    Then user is landed to product detail page
    And verify that detail is visible: product name, price, availability, condition, brand