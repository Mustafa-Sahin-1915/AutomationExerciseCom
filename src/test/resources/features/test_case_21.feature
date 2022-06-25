@test_case_21
Feature: TC_21:Add review on product

  Scenario: TC_20:Add review on product
    Given user launches browser
    And navigate to url
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    And click on View Product of first product
    Then verify that WRITE YOUR REVIEW is visible
    When review name, email and review text on product details page
    And click review submit button on product details page
    Then verify that success message Thank you for your review

