package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

public class AutomationExerciseTestCasesPage extends AutomationExerciseBasePage{

    public AutomationExerciseTestCasesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public AutomationExerciseTestCasesPage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//b[contains(text(),'Test Cases')]")
    public WebElement testCaseH2;
}
