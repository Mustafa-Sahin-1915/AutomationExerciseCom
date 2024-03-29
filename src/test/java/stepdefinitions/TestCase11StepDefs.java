package stepdefinitions;

import io.cucumber.java.en.When;
import pages.AutomationExerciseHomePage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;

public class TestCase11StepDefs {
    AutomationExerciseHomePage homePage;
    @When("click cart button on home page")
    public void click_cart_button() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        homePage.cartLink.click();
    }
}
