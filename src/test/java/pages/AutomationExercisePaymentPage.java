package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

public class AutomationExercisePaymentPage extends AutomationExerciseBasePage{

    public AutomationExercisePaymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public AutomationExercisePaymentPage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css="div.step-one h2")
    public WebElement paymentH2;

    @FindBy(name = "name_on_card")
    public WebElement nameOnCardTxt;

    @FindBy(name = "card_number")
    public WebElement cardNumberTxt;

    @FindBy(name = "cvc")
    public WebElement cvcTxt;

    @FindBy(name = "expiry_month")//MM
    public WebElement expiryMonthTxt;

    @FindBy(name = "expiry_year")//YYYY
    public WebElement expiryYearTxt;

    @FindBy(id = "submit")
    public WebElement payAndConfirmOrderBtn;

    @FindBy(xpath = "//div[@class='alert-success alert' and contains(text(),'Your order')]")
    public WebElement successfullyOrderedMessage;



}
