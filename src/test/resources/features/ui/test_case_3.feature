@test_case_3 @ui
Feature: TC3_Login User with incorrect email and password

  Scenario: TC_3_Login User with incorrect email and password
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click on signup_login button
    Then verify Login to your account is visible
    When enter incorrect email and password
    And click login button
    Then verify error your email or password is incorrect is visible