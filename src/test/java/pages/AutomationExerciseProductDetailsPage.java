package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExerciseProductDetailsPage extends AutomationExerciseBasePage{

    public AutomationExerciseProductDetailsPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='product-information']/h2")
    public WebElement productName;

    @FindBy(xpath = "//div[@class='product-information']/span/span")
    public WebElement productPrice;

    @FindBy(xpath = "(//div[@class='product-information']/p)[2]")
    public WebElement productAvailability;

    @FindBy(xpath = "(//div[@class='product-information']/p)[3]")
    public WebElement productCondition;

    @FindBy(xpath = "(//div[@class='product-information']/p)[4]")
    public WebElement productBrand;

    @FindBy(id="quantity")
    public WebElement productQuantity;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    public WebElement productAddToCartBtn;

    @FindBy(xpath = "//a[@href='/view_cart']")
    public WebElement viewCartLink;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']//a")
    public WebElement writeYourReviewLink;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement reviewName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement reviewEmail;

    @FindBy(xpath = "//textarea[@id='review']")
    public WebElement reviewMessage;

    @FindBy(xpath = "//button[@id='button-review']")
    public WebElement reviewSubmitBtn;

    @FindBy(xpath = "//*[.='Thank you for your review.']")
    public WebElement successOfReviewSendMessage;
}
