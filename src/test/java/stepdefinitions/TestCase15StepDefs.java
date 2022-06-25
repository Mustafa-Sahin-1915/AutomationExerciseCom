package stepdefinitions;

import io.cucumber.java.en.When;
import pages.AutomationExerciseHomePage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;

public class TestCase15StepDefs {
    AutomationExerciseHomePage homePage;
    @When("click signup button on home page")
    public void click_signup_button() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        homePage.signupLoginLink.click();
    }
}
