package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExerciseAccountCreatedPage {

    public AutomationExerciseAccountCreatedPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "h2 b")
    public WebElement accountCreatedH2;

    @FindBy(linkText = "Continue")
    public WebElement continueBtn;

}
