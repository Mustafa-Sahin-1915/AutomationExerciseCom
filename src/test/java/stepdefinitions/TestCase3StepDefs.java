package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AutomationExerciseLoginPage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import testdata.MockDataForUI;
import utilities.Driver;

public class TestCase3StepDefs {
    WebDriver driver;

    AutomationExerciseLoginPage loginPage;
    @When("enter incorrect email and password")
    public void enter_incorrect_email_and_password() {
        driver = Driver.getDriver();
        loginPage = (AutomationExerciseLoginPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.LoginPage);
        Driver.scrollIntoView(loginPage.loginToYourAccountH2);
        //random email and password
        loginPage.loginEmail.sendKeys(Faker.instance().internet().emailAddress());
        loginPage.loginPassword.sendKeys(Faker.instance().internet().password());
    }
    @Then("verify error your email or password is incorrect is visible")
    public void verify_error_your_email_or_password_is_incorrect_is_visible() {
        loginPage = (AutomationExerciseLoginPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.LoginPage);
        Driver.waitForVisibility(loginPage.emailOrPasswordIncorrectInfo,5);
        Assert.assertTrue(loginPage.emailOrPasswordIncorrectInfo.isDisplayed());
    }
}
