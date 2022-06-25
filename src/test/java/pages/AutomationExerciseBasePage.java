package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExerciseBasePage {

    public AutomationExerciseBasePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


}
