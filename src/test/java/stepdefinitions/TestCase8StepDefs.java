package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import utilities.Driver;

public class TestCase8StepDefs {
    AutomationExerciseHomePage homePage;
    AutomationExerciseProductsPage productsPage;
    AutomationExerciseProductDetailsPage productDetailsPage;
    WebDriver driver;
    String productDetailsLinkAddedMainUrl="";

    @When("click on Products button")
    public void click_on_products_button() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        homePage.productsLink.click();
    }
    @Then("verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        productsPage = (AutomationExerciseProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductsPage);
        Driver.scrollIntoView(productsPage.allProductsH2);
        Assert.assertTrue(productsPage.allProductsH2.isDisplayed());
    }
    @Then("the products list is visible")
    public void the_products_list_is_visible() {
        productsPage = (AutomationExerciseProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductsPage);
        Assert.assertTrue(productsPage.productListDiv.isDisplayed());
        Assert.assertTrue(productsPage.allProducts.size()>0);
    }
    @When("click on View Product of first product")
    public void click_on_view_product_of_first_product() {
        productsPage = (AutomationExerciseProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductsPage);
        productDetailsLinkAddedMainUrl = productsPage.firstProductsViewProductLink.getAttribute("href");
        productsPage.firstProductsViewProductLink.click();
    }
    @Then("user is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        String urlOfProductDetailsPage = driver.getCurrentUrl();
        Assert.assertTrue(urlOfProductDetailsPage.contains(productDetailsLinkAddedMainUrl));
    }
    @Then("verify that detail is visible: product name, price, availability, condition, brand")
    public void verify_that_detail_is_visible_product_name_price_availability_condition_brand() {
        productDetailsPage = (AutomationExerciseProductDetailsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductDetailsPage);
        Driver.scrollIntoView(productDetailsPage.productName);
        Assert.assertTrue(productDetailsPage.productName.isDisplayed());
        Assert.assertTrue(productDetailsPage.productPrice.isDisplayed());
        Assert.assertTrue(productDetailsPage.productAvailability.isDisplayed());
        Assert.assertTrue(productDetailsPage.productCondition.isDisplayed());
        Assert.assertTrue(productDetailsPage.productBrand.isDisplayed());
    }
}
