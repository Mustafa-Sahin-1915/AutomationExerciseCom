package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AutomationExerciseHomePage;
import pages.AutomationExerciseLoginPage;
import testdata.MockDataForUI;
import utilities.Driver;

public class TestCase2StepDefs {
    WebDriver driver;

    AutomationExerciseLoginPage loginPage;
    MockDataForUI mockDataForUI;
    @Then("verify Login to your account is visible")
    public void verify_login_to_your_account_is_visible() {
        driver = Driver.getDriver();
        loginPage = new AutomationExerciseLoginPage();
        Assert.assertTrue(loginPage.loginToYourAccountH2.isDisplayed());
        mockDataForUI = MockDataForUI.getInstance();
    }
    @When("enter correct email and password")
    public void enter_correct_email_and_password() {
        loginPage.loginEmail.sendKeys(mockDataForUI.getEmail());
        loginPage.loginPassword.sendKeys(mockDataForUI.getPassword());
    }
    @When("click login button")
    public void click_login_button() {
        loginPage.loginBtn.click();
    }

}
