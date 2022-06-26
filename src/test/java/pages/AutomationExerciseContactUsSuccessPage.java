package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

public class AutomationExerciseContactUsSuccessPage extends AutomationExerciseBasePage{

    public AutomationExerciseContactUsSuccessPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public AutomationExerciseContactUsSuccessPage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement contactUsSuccessMsg;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    public WebElement contactUsHomeBtn;
}
