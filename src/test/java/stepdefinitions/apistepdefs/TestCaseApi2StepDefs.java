package stepdefinitions.apistepdefs;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utilities.ApiUtils;

import static io.restassured.RestAssured.*;

public class TestCaseApi2StepDefs {
    /*
      Background: user makes setup for apis
    Given i am user on automation exercise api base

  Scenario: POST To All Products List
    Given api path api/productsList
    When user sends a POST request to get all products list api
    Then response code should be 200
    And response responseCode variable must be 405
    And response message must be This request method is not supported
     */
    protected RequestSpecification spec;
    protected Response response;

    @When("user sends a POST request to get all products list api")
    public void user_sends_a_post_request_to_get_all_products_list_api() {
        spec = ApiUtils.getSpec();
        response= given()
                .spec(spec)
                .post("/{first}");
        ApiUtils.setResponse(response);
    }
    @Then("response responseCode variable must be {int}")
    public void response_response_code_variable_must_be(Integer responseCodeExpected) {
        response = ApiUtils.getResponse();
        JsonPath jsonPath= response.jsonPath();
        Integer responseCodeActual = jsonPath.getInt("responseCode");
        Assert.assertEquals(responseCodeActual, responseCodeExpected);
    }
    @Then("response message variable must be {string}")
    public void response_message_must_be_this_request_method_is_not_supported(String responseMessageExpected) {
        response = ApiUtils.getResponse();
        JsonPath jsonPath= response.jsonPath();
        String responseMessageActual= jsonPath.getString("message");
        Assert.assertEquals(responseMessageActual, responseMessageExpected);

    }
}
