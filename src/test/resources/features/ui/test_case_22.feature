@test_case_22 @ui
Feature: TC_22:Add to cart from Recommended items

  Scenario: TC_22:Add to cart from Recommended items
    Given user launches browser
    And navigate to url
    When scroll bottom to the Recommended Items on main page
    And click on Add To Cart on visible Recommended product
    And click View Cart button on modal
    Then verify that recommended product is displayed in cart page


