@test_case_6 @ui
Feature: TC6_Contact Us Form

  Scenario: TC_6_Contact Us Form
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When click on Contact Us button
    Then verify GET IN TOUCH is visible
    When Enter name, email, subject and message
    And upload file
    And click submit button
    And click OK button
    Then verify success message Success.Your details have been submitted successfully is visible
    And click Home button and verify that landed to home page successfully