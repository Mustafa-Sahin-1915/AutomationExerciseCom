package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AutomationExerciseHomePage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import pages.AutomationExerciseTestCasesPage;

public class TestCase7StepDefs {
    AutomationExerciseHomePage homePage;
    AutomationExerciseTestCasesPage testCasesPage;
    @When("click on Test Cases button")
    public void click_on_test_cases_button() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        homePage.testCasesLink.click();
    }
    @Then("verify user is navigated to test cases page successfully")
    public void verify_user_is_navigated_to_test_cases_page_successfully() {
        testCasesPage = (AutomationExerciseTestCasesPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.TestCasesPage);
        Assert.assertTrue(testCasesPage.testCaseH2.isDisplayed());
    }
}
