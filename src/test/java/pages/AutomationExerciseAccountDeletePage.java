package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

public class AutomationExerciseAccountDeletePage extends AutomationExerciseBasePage {

    public AutomationExerciseAccountDeletePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public AutomationExerciseAccountDeletePage(ContextDataMap contextDataMap) {
        super(contextDataMap);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'ACCOUNT DELETED')]")
    public WebElement accountDeleteH2;

    @FindBy(linkText = "Continue")
    public WebElement continueBtn;
}
