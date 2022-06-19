@smoke_test @test_case_1
Feature: TC_1_Register User

  Scenario:TC_1_scenario1_register_user
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click on signup_login button
    Then verify New User Signup is visible
    When enter name and email address
    And click signup button
    Then verify ENTER ACCOUNT INFORMATION is visible
    When fill the details, title, name, email, password, date of birth
    And select checkbox sign up for our newsletter
    And fill the details first name, last name, company, address, address2, country, state, city, zipcode, mobile number
    And click create account button
    Then verify that ACCOUNT CREATED is visible
    When click Continue button
    Then verify that Logged in as username is visible
    When click Delete Account button
    Then verify that ACCOUNT DELETED is visible
    And click after delete Continue button
