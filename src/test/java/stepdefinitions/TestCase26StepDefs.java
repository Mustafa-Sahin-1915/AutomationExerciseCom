package stepdefinitions;

import io.cucumber.java.en.When;
import pages.AutomationExerciseHomePage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import utilities.Driver;

public class TestCase26StepDefs {
    private AutomationExerciseHomePage homePage;
    @When("scroll up page to top")
    public void scroll_up_page_to_top() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Driver.scrollIntoView(homePage.sliderCarouselH2s.get(0));
    }
}
