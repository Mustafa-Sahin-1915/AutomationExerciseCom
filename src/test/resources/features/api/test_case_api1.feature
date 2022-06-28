@test_case_api_1 @api
Feature: TC_api_1_Get All Products List

  Background: user makes setup for apis
    Given i am user on automation exercise api base

  Scenario: TC_api_1 Get All Products List
    Given api path api/productsList
    When user sends a GET request to get all products list api
    Then response code should be 200
    And response must include all of products
