package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AutomationExerciseHomePage;
import pages.AutomationExerciseLoginPage;
import utilities.Driver;

public class TestCase4StepDefs {
    AutomationExerciseHomePage homePage;
    AutomationExerciseLoginPage loginPage;

    @When("click logout button")
    public void click_logout_button() {
        homePage = new AutomationExerciseHomePage();
        Driver.waitForVisibility(homePage.logoutBtn,10);
        homePage.logoutBtn.click();
        loginPage = new AutomationExerciseLoginPage();
    }
    @Then("verify that user is navigated to login page")
    public void verify_that_user_is_navigated_to_login_page() {
        Assert.assertTrue(loginPage.newUserSignupH2.isDisplayed());
    }
}
