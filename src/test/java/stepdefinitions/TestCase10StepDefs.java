package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AutomationExerciseHomePage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import testdata.MockDataForUI;
import utilities.Driver;

public class TestCase10StepDefs {
    AutomationExerciseHomePage homePage;
    WebDriver driver = Driver.getDriver();
    @When("scroll down to footer")
    public void scroll_down_to_footer() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Driver.scrollIntoView(homePage.subscribeH2);

    }
    @Then("verify text SUBSCRIPTION")
    public void verify_text_subscription() {

        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Assert.assertTrue(homePage.subscribeH2.isDisplayed());
    }
    @When("enter email address in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        homePage.subscribeEmail.sendKeys(MockDataForUI.getInstance().getEmail());
        homePage.subscribeSubmitBtn.click();
    }
    @Then("verify success message You have been successfully subscribed is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Driver.waitForVisibility(homePage.subscribeSuccessfulMsg,5);
        Assert.assertTrue(homePage.subscribeSuccessfulMsg.isDisplayed());
    }

}
