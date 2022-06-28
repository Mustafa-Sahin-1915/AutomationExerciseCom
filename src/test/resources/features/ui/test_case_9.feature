@test_case_9 @ui
Feature: TC9_Search Product

  Scenario Outline: TC_9_Search Product
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    When enter "<product_name>" in search input and click search button
    Then verify searched products is visible
    And verify all the products related to search are visible

    Examples:
    |product_name|
    |Men Tshirt  |