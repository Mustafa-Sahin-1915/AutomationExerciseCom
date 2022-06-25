package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExerciseBrandProductsPage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import pages.AutomationExerciseProductsPage;
import utilities.Driver;

public class TestCase20StepDefs {

    /*
    Given user launches browser
    And navigate to url
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    When enter product name in search input and click search button
    Then verify that SEARCHED PRODUCTS is visible
    And verify that all products related to search are visible
    When add all searched products to cart
    Then click cart button on home page
    Then verify that all searched products added into cart
    Then enter correct email and password
    And verify that Logged in as username is visible
    And click cart button on home page
    Then verify that all searched products added into cart after login as well
     */
    @When("enter product name in search input and click search button")
    public void enter_product_name_in_search_input_and_click_search_button() {

    }
    @Then("verify that SEARCHED PRODUCTS is visible")
    public void verify_that_searched_products_is_visible() {

    }
    @Then("verify that all products related to search are visible")
    public void verify_that_all_products_related_to_search_are_visible() {

    }
    @When("add all searched products to cart")
    public void add_all_searched_products_to_cart() {

    }
    @Then("verify that all searched products added into cart")
    public void verify_that_all_searched_products_added_into_cart() {

    }
    @Then("verify that all searched products added into cart after login as well")
    public void verify_that_all_searched_products_added_into_cart_after_login_as_well() {

    }

}
