@test_case_4 @ui
Feature: TC4_Logout user

  Scenario: TC_4_Logout user
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click on signup_login button
    Then verify Login to your account is visible
    When enter correct email and password
    And click login button
    Then verify that Logged in as username is visible
    When click logout button
    Then verify that user is navigated to login page