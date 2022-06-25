package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.*;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class TestCase13StepDefs {
    WebDriver driver;
    AutomationExerciseProductDetailsPage productDetailsPage;
    AutomationExerciseHomePage homePage;

    AutomationExerciseViewCartPage viewCartPage;

    @Then("click View Product for any product on home page")
    public void click_view_product_for_any_product_on_home_page() {
        driver = Driver.getDriver();
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Driver.scrollIntoView(homePage.firstProductsViewProductLink);
        homePage.firstProductsViewProductLink.click();

    }

    @Then("verify product detail is opened")
    public void verify_product_detail_is_opened() {
        productDetailsPage = (AutomationExerciseProductDetailsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductDetailsPage);
        String urlOfProductDetailsPage = driver.getCurrentUrl();
        Assert.assertTrue(productDetailsPage.productName.isDisplayed());
        Driver.scrollIntoView(productDetailsPage.productCondition);
    }

    @Then("increase quantity to {int}")
    public void increase_quantity_to(Integer inc) {
        productDetailsPage = (AutomationExerciseProductDetailsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductDetailsPage);
        String val = productDetailsPage.productQuantity.getAttribute("value");
        String value = String.valueOf(inc);
        productDetailsPage.productQuantity.click();
        productDetailsPage.productQuantity.sendKeys(Keys.BACK_SPACE);
        productDetailsPage.productQuantity.sendKeys(value);

    }

    @Then("click Add to cart button")
    public void click_add_to_cart_button() {
        productDetailsPage = (AutomationExerciseProductDetailsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductDetailsPage);
        Driver.scrollIntoView(productDetailsPage.productName);
        productDetailsPage.productAddToCartBtn.click();
        Driver.wait(1);
    }
    @Then("verify that product is displayed in cart page with exact quantity {int}")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity(Integer quantity) {
        Driver.getDriver().navigate().refresh();
        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);
        Driver.waitForVisibility(viewCartPage.proceedToCheckoutBtn,5);
        Driver.scrollIntoView(viewCartPage.itemHeaderTr);
        List<WebElement> addedProductsInCart = viewCartPage.addedProductsInCart;
        WebElement elInCart;
        String quantityS =String.valueOf(quantity);
        System.out.println(addedProductsInCart.size());
        //for (int i = 0; i < addedProductsInCart.size(); i++) {
            //elInCart = addedProductsInCart.get(i);
            elInCart = addedProductsInCart.get(0);
            String quan = elInCart.findElement(By.xpath("td[4]")).getText();
            Assert.assertEquals(quan, quantityS);
        //}
    }
}
