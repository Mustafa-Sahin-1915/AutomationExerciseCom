@test_case_19
Feature: TC_19:View & Cart Brand Products

  Scenario: TC_19:View & Cart Brand Products
    Given user launches browser
    And navigate to url
    When click on Products button
    Then verify that Brands are visible on left side bar
    When click on "POLO" brand name
    Then verify that user is navigated to "POLO" brand page and products are displayed
    When click on "MADAME" brand name
    Then verify that user is navigated to "MADAME" brand page and products are displayed



