package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AutomationExerciseLoginPage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import testdata.MockDataForUI;
import utilities.Driver;

public class TestCase5StepDefs {
    AutomationExerciseLoginPage loginPage;
    @When("enter name and already registered email address")
    public void enter_name_and_already_registered_email_address() {
        loginPage = (AutomationExerciseLoginPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.LoginPage);
        Driver.scrollIntoView(loginPage.newUserSignupH2);
        loginPage.signupName.sendKeys(Faker.instance().name().firstName());
        loginPage.signupEmail.sendKeys(MockDataForUI.getInstance().getEmail());
    }
    @Then("Verify error Email Address already exist is visible")
    public void verify_error_email_address_already_exist_is_visible() {
        loginPage = (AutomationExerciseLoginPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.LoginPage);
        Driver.waitForVisibility(loginPage.emailAddressAlreadyExistInfo,5);
        Assert.assertTrue(loginPage.emailAddressAlreadyExistInfo.isDisplayed());
    }
}
