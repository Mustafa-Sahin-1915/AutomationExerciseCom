package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExerciseEnterAccountInfoPage {

    public AutomationExerciseEnterAccountInfoPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='login-form']/h2/b")
    public WebElement enterAccountInfoH2;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement titleMrRadioBtn;

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement titleMrsRadioBtn;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement accountName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement accountEmail;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement accountPassword;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement accountDayOfBirth;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement accountMonthOfBirth;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement accountYearOfBirth;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement signupForNewsletterCheckbox;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement receiveSpecialOfferCheckbox;

    @FindBy(xpath = "(//h2[@class='title text-center']/b)[2]")
    public WebElement addressInfoH2;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement address1;

    @FindBy(xpath = "//input[@id='address2']")
    public WebElement address2;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement country;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountBtn;

}
