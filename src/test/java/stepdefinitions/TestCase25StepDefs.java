package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExerciseHomePage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import utilities.Driver;

import java.util.List;

public class TestCase25StepDefs {
/*
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    And scroll down to footer
    Then verify that SUBSCRIPTION is visible
    When click on arrow at bottom right side to move upward
    Then verify that Full-Fledged practice website for Automation Engineers text is visible on screen
 */
    private AutomationExerciseHomePage homePage;
    @Then("verify that SUBSCRIPTION is visible")
    public void verify_that_subscription_is_visible() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Assert.assertTrue(homePage.subscribeH2.isDisplayed());
    }
    @When("click on arrow at bottom right side to move upward")
    public void click_on_arrow_at_bottom_right_side_to_move_upward() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Driver.waitForClickablility(homePage.scrollUpBtnOnRight, 2);
        homePage.scrollUpBtnOnRight.click();
    }
    @Then("verify that Full-Fledged practice website for Automation Engineers text is visible on screen")
    public void verify_that_full_fledged_practice_website_for_automation_engineers_text_is_visible_on_screen() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        List<WebElement> sliderCarouselH2s = homePage.sliderCarouselH2s;
        boolean isVisible = false;
        for (WebElement w:sliderCarouselH2s){
            if (w.isDisplayed()){
                isVisible=true;break;
            }
        }
        Assert.assertTrue(isVisible);
    }
}
