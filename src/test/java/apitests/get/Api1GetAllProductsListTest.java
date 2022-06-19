package apitests.get;

import apitests.baseurl.AutomationExerciseComBaseUrl;
import apitests.pojos.Products;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.JsonUtil;

import static io.restassured.RestAssured.*;

public class Api1GetAllProductsListTest extends AutomationExerciseComBaseUrl {

    @Test
    public void testGetAllProducsList(){
        spec.pathParam("first","productsList");

        Response response =
                given().header("Accept",ContentType.JSON).
                        spec(spec).log().all().
                        contentType(ContentType.JSON).
                        when().log().all().
                        get("/{first}");
        //response.prettyPrint();
        response.then().assertThat().statusCode(200);
        Products products = JsonUtil.convertJsonToJavaObject(response.asString(), Products.class);
        //Products products1 = response.as(Products.class);
        System.out.println(products);
        //System.out.println(products1);


    }
}
