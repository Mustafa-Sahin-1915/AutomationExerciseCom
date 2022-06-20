package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExerciseViewCartPage {

    public AutomationExerciseViewCartPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr")
    public List<WebElement> addedProductsInCart;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//td[contains(text(),'Item')]")
    public WebElement itemHeaderTr;

}
