package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExerciseSearchedProductsPage extends AutomationExerciseBasePage{

    public AutomationExerciseSearchedProductsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement searchedProductsH2;

    @FindBy(css = "div.single-products")
    public List<WebElement> allProducts;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    public List<WebElement> allProductNames;
    @FindBy(xpath = "//div[@class='productinfo text-center']/a")
    public List<WebElement> allProductsAddToCartBtns;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingBtn;

    @FindBy(xpath = "//div[@class='modal-body']//a")
    public WebElement viewCartOnModal;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[@href='/view_cart']")
    public WebElement viewCartOnTopNavBar;

}
