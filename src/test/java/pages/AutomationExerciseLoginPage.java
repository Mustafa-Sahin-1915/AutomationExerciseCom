package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

public class AutomationExerciseLoginPage extends AutomationExerciseBasePage{

    public AutomationExerciseLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public AutomationExerciseLoginPage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//div[@class='signup-form']/h2")
    public WebElement newUserSignupH2;

    @FindBy(xpath = "//div[@class='login-form']/h2")
    public WebElement loginToYourAccountH2;

    @FindBy(xpath="//input[@data-qa='signup-name']")
    public WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpBtn;

    @FindBy(xpath="//input[@data-qa='login-email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginBtn;

    @FindBy(xpath ="//p[contains(text(),'Your email or password is incorrect!')]")
    public WebElement emailOrPasswordIncorrectInfo;

    @FindBy(xpath ="//p[contains(text(),'Email Address already exist')]")
    public WebElement emailAddressAlreadyExistInfo;

}
