@test_case_26 @ui
Feature: TC_26:Verify Scroll Up without 'Arrow' button and Scroll Down functionality

  Scenario: TC_26:Verify Scroll Up without 'Arrow' button and Scroll Down functionality
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    And scroll down to footer
    Then verify that SUBSCRIPTION is visible
    When scroll up page to top
    Then verify that Full-Fledged practice website for Automation Engineers text is visible on screen




