package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

import java.util.List;

public class AutomationExerciseHomePage extends AutomationExerciseBasePage{
    public AutomationExerciseHomePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    public AutomationExerciseHomePage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsLink;

    @FindBy(xpath = "//a[@href='/view_cart']")
    public WebElement cartLink;

    @FindBy(xpath = "//div[@class='modal-body']//a")
    public WebElement modalViewCartLink;

    @FindBy(xpath="//h2[@class='title text-center'] ")
    public WebElement allProductsHeader;

    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement searchBox;

    @FindBy(xpath = "(//div[@class='single-products']//p)[1]")
    public WebElement productsFirstName;

    @FindBy(xpath="//button[@id='submit_search']")
    public WebElement searchButton;

    @FindBy(xpath="//h2[@class='title text-center']")
    public WebElement searchedProductsHeader;
    @FindBy(xpath ="(//div[@class='single-products']//p)")
    public List<WebElement> productsNames;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signupLoginLink;

    @FindBy(partialLinkText = "Logged in as")
    public WebElement loggedInAsTxt;

    @FindBy(partialLinkText = "Delete Account")
    public WebElement deleteAccountBtn;

    @FindBy(partialLinkText = "Logout")
    public WebElement logoutBtn;

    @FindBy(partialLinkText = "Contact us")
    public WebElement contactUsLink;
    @FindBy(partialLinkText = "Test Cases")
    public WebElement testCasesLink;

    @FindBy(css = "div.single-widget h2")
    public WebElement subscribeH2;
    @FindBy(id="susbscribe_email")
    public WebElement subscribeEmail;
    @FindBy(id="subscribe")
    public WebElement subscribeSubmitBtn;

    @FindBy(xpath = "//*[contains(text(),'You have been successfully subscribed')]")
    public WebElement subscribeSuccessfulMsg;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement firstProductsViewProductLink;

    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])")
    public List<WebElement> addToCartBtns;

    @FindBy(xpath = "//a[contains(@href,'Women')]")
    public WebElement womenCategoryLeftSideBar;

    @FindBy(xpath = "//a[contains(@href,'Men')]")
    public WebElement menCategoryLeftSideBar;

    @FindBy(xpath = "//a[contains(@href,'Kids')]")
    public WebElement kidsCategoryLeftSideBar;

    @FindBy(xpath ="//div[@id='accordian']//a" )
    public List<WebElement> accordionAlinks;

    @FindBy(xpath = "//div[@class='left-sidebar']/h2")
    public WebElement leftSideBarCategoryH2;

    @FindBy(xpath = "//div[@class='brands_products']/h2")
    public WebElement brandProductsH2;

    @FindBy(xpath = "//div[@class='brands_products']//a")
    public List<WebElement> brandsAlinks;


    @FindBy(xpath = "(//div[@id='recommended-item-carousel']//a)[1]")
    public WebElement firstRecommendedItemAddBtn;

    @FindBy(xpath = "//div[@id='recommended-item-carousel']//a")
    public List<WebElement> RecommendedItemAddBtns;

    @FindBy(xpath = "//div[@id='recommended-item-carousel']//p")
    public List<WebElement> RecommendedItemNames;

    @FindBy(xpath = "(//div[@id='recommended-item-carousel']//p)[1]")
    public WebElement firstRecommendedItemCode;


    public WebElement getCategoryByVisibleName(String categoryName){
        for(WebElement w:accordionAlinks){
            if (w.isDisplayed() && w.getText().equalsIgnoreCase(categoryName)){
                return w;
            }
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
