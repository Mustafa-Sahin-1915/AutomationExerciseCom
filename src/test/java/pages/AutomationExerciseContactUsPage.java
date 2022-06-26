package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

public class AutomationExerciseContactUsPage extends AutomationExerciseBasePage{
    public AutomationExerciseContactUsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public AutomationExerciseContactUsPage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='contact-form']/h2")
    public WebElement getInTouchH2;

    @FindBy(xpath = "//input[@data-qa='name']")
    public WebElement contactFormName;

    @FindBy(xpath = "//input[@data-qa='email']")
    public WebElement contactFormEmail;

    @FindBy(xpath = "//input[@data-qa='subject']")
    public WebElement contactFormSubject;

    @FindBy(id = "message")
    public WebElement contactFormMessage;

    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement contactFormUploadFile;


    @FindBy(xpath="//input[@name='submit']")
    public WebElement contactFormSubmitBtn;

}
