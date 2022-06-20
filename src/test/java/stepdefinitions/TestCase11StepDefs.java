package stepdefinitions;

import io.cucumber.java.en.When;
import pages.AutomationExerciseHomePage;

public class TestCase11StepDefs {
    AutomationExerciseHomePage homePage;
    @When("click cart button")
    public void click_cart_button() {
        homePage = new AutomationExerciseHomePage();
        homePage.cartLink.click();

    }
}
