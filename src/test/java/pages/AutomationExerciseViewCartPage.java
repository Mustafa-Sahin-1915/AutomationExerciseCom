package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

import java.util.List;

public class AutomationExerciseViewCartPage extends AutomationExerciseBasePage{

    public AutomationExerciseViewCartPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    public AutomationExerciseViewCartPage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr")
    public List<WebElement> addedProductsInCart;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr/td[2]")
    public List<WebElement> productsInCartDescriptions;

    @FindBy(xpath = "//td[contains(text(),'Item')]")
    public WebElement itemHeaderTr;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement registerLoginBtn;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    public WebElement continueOnCartBtn;

    @FindBy(xpath = "//div[@class='modal-body']//a")
    public WebElement signupLoginOnCartPageLink;

    @FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr/td[last()]/a")
    public List<WebElement> productDeleteBtns;

    @FindBy(xpath = "//span[@id='empty_cart']/p/b")
    public WebElement emptyCartMsg;
}
