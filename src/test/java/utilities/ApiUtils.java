package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ApiUtils {
    private static RequestSpecification spec;
    private static Response response;

    /*
    we can use that method to create common spec features
     which will be used all of Api tests
     */
    public static RequestSpecification getSpec(){
        if (spec==null){
            spec = setUpSpec();
        }
        return spec;
    }
    private static String getBearerToken(){
        RequestSpecification spec1;
        spec1 = new RequestSpecBuilder().
                setBaseUri("https://medunna.com/api").
                build();
        spec1.header("Accept", ContentType.JSON);
        spec1.contentType(ContentType.JSON);
        spec1.pathParams("first","authenticate");

        String userNameApi = ConfigReader.getProperty("userNameApi");
        String passwordApi = ConfigReader.getProperty("passwordApi");

        String str = "{\"password\":\"%s\",\"rememberMe\":true,\"username\":\"%s\"}";
        String requestBody = String.format(str,passwordApi,userNameApi);

        Response response1 = given()
                .spec(spec1)
                .body(requestBody)
                .post("/{first}");

        response1.prettyPrint();
        JsonPath jsonPath = response1.jsonPath();
        String token = jsonPath.getString("id_token");
        setResponse(response1);
        return token;
    }
    private static RequestSpecification setUpSpec(){
        RequestSpecification spec;
        String base_api_url = ConfigReader.getProperty("api_base_url");
        spec = new RequestSpecBuilder().
                setBaseUri(base_api_url).
                build();
        spec.header("Accept", ContentType.JSON);
        spec.contentType(ContentType.JSON);
        //spec.header("Authorization", "Bearer " + getBearerToken());
        return spec;
    }

    public static Response getResponse() {
        return response;
    }

    public static void setResponse(Response response) {
        ApiUtils.response = response;
    }

    private static ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
    }
    //1. method: this method will convert Json data to Java Object(de-serialization)
    //  Class<BookingPojo>
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls){ //generic method
        T javaResult = null;
        try {
            javaResult = mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaResult;
    }
    //2. Method: this method will convert Java Object to Json data (serialization)
    public static String convertJavaObjectToJson(Object obj){
        String jsonResult = null;
        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

}
