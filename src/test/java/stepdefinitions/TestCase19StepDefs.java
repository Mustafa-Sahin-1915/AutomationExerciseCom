package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExerciseBrandProductsPage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import pages.AutomationExerciseProductsPage;
import utilities.Driver;

public class TestCase19StepDefs {
    AutomationExerciseProductsPage productsPage;
    AutomationExerciseBrandProductsPage brandProductsPage;
    @Then("verify that Brands are visible on left side bar")
    public void verify_that_brands_are_visible_on_left_side_bar() {
        productsPage = (AutomationExerciseProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductsPage);
        Assert.assertTrue(productsPage.brandProductsH2.isDisplayed());

    }
    @When("click on {string} brand name")
    public void click_on_brand_name(String brandName) {
        productsPage = (AutomationExerciseProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductsPage);
        WebElement brandLink = productsPage.getBrandByVisibleName(brandName);
        Driver.scrollIntoView(brandLink);
        Driver.waitForClickablility(brandLink, 3);
        Driver.clickByHoverOver(brandLink);

    }
    @Then("verify that user is navigated to {string} brand page and products are displayed")
    public void verify_that_user_is_navigated_to_brand_page_and_products_are_displayed(String brandName) {
        brandProductsPage = (AutomationExerciseBrandProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.BrandProductsPage);
        Driver.waitForVisibility(brandProductsPage.brandProductH2, 3);
        String brandProductsStr = brandProductsPage.brandProductH2.getText().toUpperCase();
        brandName = brandName.toUpperCase();
        Assert.assertTrue(brandProductsStr.contains(brandName));
    }

}
