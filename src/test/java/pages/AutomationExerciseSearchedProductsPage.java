package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExerciseSearchedProductsPage {

    public AutomationExerciseSearchedProductsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement searchedProductsH2;

    @FindBy(css = "div.single-products")
    public List<WebElement> allProducts;

}
