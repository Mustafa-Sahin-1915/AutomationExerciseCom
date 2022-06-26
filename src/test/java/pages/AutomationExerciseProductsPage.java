package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

import java.util.List;

public class AutomationExerciseProductsPage extends AutomationExerciseBasePage{
    public AutomationExerciseProductsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public AutomationExerciseProductsPage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    public WebElement allProductsH2;

    @FindBy(css = "div.features_items")
    public WebElement productListDiv;
    @FindBy(css = "div.single-products")
    public List<WebElement> allProducts;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement firstProductsViewProductLink;

    @FindBy(id = "search_product")
    public WebElement searchProductBox;
    @FindBy(id="submit_search")
    public WebElement submitSearchBtn;

    @FindBy(css = "button.btn.btn-success.close-modal.btn-block")
    public WebElement continueShoppingBtn;

    @FindBy(xpath = "(//a[@href='/view_cart'])[2]")
    public WebElement viewCartModalBtn;

    @FindBy(xpath = "(//div[@class='product-overlay']//i)[1]")
    public WebElement firstProductAddToCartOverlay;

    @FindBy(xpath = "(//div[@class='product-overlay']//i)[2]")
    public WebElement secondProductAddToCartOverlay;


    @FindBy(xpath = "//div[@class='brands_products']/h2")
    public WebElement brandProductsH2;

    @FindBy(xpath = "//div[@class='brands_products']//a")
    public List<WebElement> brandsAlinks;


    public WebElement getFirstProduct(){
        if (allProducts.size()>0) {
           return allProducts.get(0);
        }
        return null;
    }
    public WebElement getSecondProduct(){
        if (allProducts.size()>0) {
            return allProducts.get(1);
        }
        return null;
    }

    public WebElement getBrandByVisibleName(String brandName){
        String justText = null;
        for(WebElement w:brandsAlinks){
            justText = w.getText().replaceAll("[^a-zA-Z]", "");
            if (w.isDisplayed() && justText.equalsIgnoreCase(brandName)){
                return w;
            }
        }
        return null;
    }
}
