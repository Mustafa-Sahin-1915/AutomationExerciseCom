@test_case_10 @ui
Feature: TC10_Verify Subscription in home page

  Scenario: TC_10_Verify Subscription in home page
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When scroll down to footer
    Then verify text SUBSCRIPTION
    When enter email address in input and click arrow button
    Then verify success message You have been successfully subscribed is visible