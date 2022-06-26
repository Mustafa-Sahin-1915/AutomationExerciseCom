package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

public class AutomationExercisePaymentDonePage extends AutomationExerciseBasePage{

    public AutomationExercisePaymentDonePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public AutomationExercisePaymentDonePage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@data-qa='order-placed']")
    public WebElement orderPlacedH2;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement downloadInvoiceBtn;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueBtn;


}
