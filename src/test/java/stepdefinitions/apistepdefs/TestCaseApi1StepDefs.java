package stepdefinitions.apistepdefs;

import data.pojos.Products;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ApiUtils;

import static io.restassured.RestAssured.*;

public class TestCaseApi1StepDefs {

    protected RequestSpecification spec;
    protected Response response;

    @Given("i am user on automation exercise api base")
    public void i_am_user_on_automation_exercise_api_base() {
        spec = ApiUtils.getSpec();
   }

    @Given("api path api\\/productsList")
    public void api_path_api_products_list() {
        spec.pathParam("first", "productsList");
    }
    @When("user sends a GET request to get all products list api")
    public void user_sends_a_get_request_to_get_all_products_list_api() {
        response= given()
                .spec(spec)
                .get("/{first}");
        ApiUtils.setResponse(response);
    }
    @Then("response code should be {int}")
    public void response_code_should_be(Integer statusCode) {
        response = ApiUtils.getResponse();
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("response must include all of products")
    public void response_must_include_all_of_products() {
        response = ApiUtils.getResponse();
        Products products = ApiUtils.convertJsonToJavaObject(response.asString(), Products.class);
        //Products products1 = response.as(Products.class);
        System.out.println(products);
        //System.out.println(products1);
    }
}
