package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExerciseProductsPage {
    public AutomationExerciseProductsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    public WebElement allProductsH2;

    @FindBy(css = "div.features_items")
    public WebElement productListDiv;
    @FindBy(css = "div.single-products")
    public List<WebElement> allProducts;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement firstProductsViewProductLink;
}
