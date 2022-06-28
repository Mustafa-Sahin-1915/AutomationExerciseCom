@test_case_5 @ui
Feature: TC5_Register User with existing email

  Scenario: TC_5_Register User with existing email
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click on signup_login button
    Then verify New User Signup is visible
    When enter name and already registered email address
    And click signup button
    Then Verify error Email Address already exist is visible
