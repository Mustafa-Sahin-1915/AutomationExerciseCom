package pages;

import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

public class AutomationExerciseBasePage {

    private ContextDataMap contextDataMap;
    public AutomationExerciseBasePage() {
        contextDataMap = new ContextDataMap();
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public AutomationExerciseBasePage(ContextDataMap contextData) {
        this.contextDataMap = contextData;
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public ContextDataMap getContextData() {
        return contextDataMap;
    }
}
