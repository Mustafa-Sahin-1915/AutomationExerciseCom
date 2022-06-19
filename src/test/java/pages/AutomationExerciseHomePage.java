package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExerciseHomePage {
    public AutomationExerciseHomePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsLink;

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


}
