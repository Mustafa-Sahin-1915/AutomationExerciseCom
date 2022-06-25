package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePaymentDonePage extends AutomationExerciseBasePage{

    public AutomationExercisePaymentDonePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@data-qa='order-placed']")
    public WebElement orderPlacedH2;

    @FindBy(xpath = "//a[contains(@href,'/download_invoice')]")
    public WebElement downloadInvoiceBtn;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueBtn;


}
