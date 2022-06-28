@test_case_api_2 @api
Feature: TC_api_1_POST To All Products List

  Background: user makes setup for apis
    Given i am user on automation exercise api base

  Scenario: POST To All Products List
    Given api path api/productsList
    When user sends a POST request to get all products list api
    Then response code should be 200
    And response responseCode variable must be 405
    And response message variable must be "This request method is not supported."
