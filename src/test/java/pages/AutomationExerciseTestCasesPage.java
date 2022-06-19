package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExerciseTestCasesPage {

    public AutomationExerciseTestCasesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//b[contains(text(),'Test Cases')]")
    public WebElement testCaseH2;
}
