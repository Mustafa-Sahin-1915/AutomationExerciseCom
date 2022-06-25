package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExerciseCheckOutPage extends AutomationExerciseBasePage{

    public AutomationExerciseCheckOutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//h2[@class='heading'])[1]")
    public WebElement addressDetailsH2;

    @FindBy(xpath = "(//ul[@id='address_delivery']/li)[2]")
    public WebElement deliveryFirstAndLastName;

    @FindBy(xpath = "(//ul[@id='address_delivery']/li)[3]")
    public WebElement deliveryAddress1;

    @FindBy(xpath = "(//ul[@id='address_delivery']/li)[4]")
    public WebElement deliveryAddress2;

    @FindBy(xpath = "(//ul[@id='address_delivery']/li)[5]")
    public WebElement deliveryAddress3;

    @FindBy(xpath = "(//ul[@id='address_delivery']/li)[6]")
    public WebElement deliveryCityStatePostCode;

    @FindBy(xpath = "(//ul[@id='address_delivery']/li)[7]")
    public WebElement deliveryCountry;

    @FindBy(xpath = "(//ul[@id='address_delivery']/li)[8]")
    public WebElement deliveryPhone;

    @FindBy(xpath = "(//ul[@id='address_invoice']/li)[2]")
    public WebElement billingFirstAndLastName;

    @FindBy(xpath = "(//ul[@id='address_invoice']/li)[3]")
    public WebElement billingAddress1;

    @FindBy(xpath = "(//ul[@id='address_invoice']/li)[4]")
    public WebElement billingAddress2;

    @FindBy(xpath = "(//ul[@id='address_invoice']/li)[5]")
    public WebElement billingAddress3;

    @FindBy(xpath = "(//ul[@id='address_invoice']/li)[6]")
    public WebElement billingCityStatePostCode;

    @FindBy(xpath = "(//ul[@id='address_invoice']/li)[7]")
    public WebElement billingCountry;

    @FindBy(xpath = "(//ul[@id='address_invoice']/li)[8]")
    public WebElement billingPhone;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement orderMessageTextArea;

    @FindBy(css ="a.btn.btn-default.check_out" )
    public WebElement placeOrderBtn;

    @FindBy(xpath = "//div[@id='cart_info']/table/tbody/tr")
    public WebElement cartInfoTableTrs;

    @FindBy(xpath = "//div[@id='cart_info']/table/tbody/tr[last()]")
    public WebElement totalAmountTr;

    @FindBy(xpath = "//div[@id='cart_info']/table/tbody/tr[position()<last()]/td[2]")
    public WebElement descriptionsOfCartItems;

    @FindBy(xpath = "//div[@id='cart_info']/table/tbody/tr[position()<last()]/td[3]")
    public WebElement pricesOfCartItems;

    @FindBy(xpath = "//div[@id='cart_info']/table/tbody/tr[position()<last()]/td[4]")
    public WebElement quantitiesOfCartItems;

    @FindBy(xpath = "//div[@id='cart_info']/table/tbody/tr[position()<last()]/td[5]")
    public WebElement totalsOfCartItems;

}
