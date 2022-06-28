@test_case_18 @ui
Feature: TC_18:View Category Products

  Scenario: TC_18:View Category Products
    Given user launches browser
    And navigate to url
    Then verify that categories are visible on left side bar
    When click women category on left side bar
    And click on "Dress" sub category of "Women" category
    Then verify that "Dress" sub category products page is displayed
    And verift that "WOMEN - DRESS PRODUCTS" text on "Dress" sub category products page
    Then click on any "TSHIRTS" link of "Men" category
    Then verify that user nagivated to "TSHIRTS" link of "Men" category



