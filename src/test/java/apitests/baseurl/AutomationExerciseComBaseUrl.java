package apitests.baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class AutomationExerciseComBaseUrl {
    protected RequestSpecification spec;

    //If you use @before annotation at th etop of the method,
    // it means the method will be executed before every test method
    @BeforeMethod
    public void setUp(){
        spec = new RequestSpecBuilder().
                setBaseUri("https://automationexercise.com/api").
                build();
    }

    //where do you get dependencies from, our company has own repository for depencies,
    //I get our dependencies from there
}
