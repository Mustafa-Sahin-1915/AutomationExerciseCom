@test_case_25 @ui
Feature: TC_25:Verify Scroll Up using 'Arrow' button and Scroll Down functionality

  Scenario: TC_25:Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    And scroll down to footer
    Then verify that SUBSCRIPTION is visible
    When click on arrow at bottom right side to move upward
    Then verify that Full-Fledged practice website for Automation Engineers text is visible on screen




