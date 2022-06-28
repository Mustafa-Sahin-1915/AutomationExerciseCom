@test_case_11 @ui
Feature: TC11_Verify Subscription in cart page

  Scenario: TC_11_Verify Subscription in cart page
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click cart button on home page
    And scroll down to footer
    Then verify text SUBSCRIPTION
    And enter email address in input and click arrow button
    Then verify success message You have been successfully subscribed is visible
