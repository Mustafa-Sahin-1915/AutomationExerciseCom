@test_case_2
Feature: TC_2_Login with correct email and password

  Scenario: TC_2_login_with_correct_email_and_password
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click on signup_login button
    Then verify Login to your account is visible
    When enter correct email and password
    And click login button
    Then verify that Logged in as username is visible
    When click Delete Account button
    Then verify that ACCOUNT DELETED is visible
