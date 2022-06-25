package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.*;
import testdata.MockDataForUI;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     /*
    Given user launches browser
    And navigate to url
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    */
    List<String> productNamesInCart = new ArrayList<>();
    AutomationExerciseProductsPage productsPage;
    AutomationExerciseSearchedProductsPage searchedProductsPage;
    AutomationExerciseViewCartPage viewCartPage;
    @When("enter product name in search input and click search button")
    public void enter_product_name_in_search_input_and_click_search_button() {
        productsPage = (AutomationExerciseProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductsPage);
        Driver.scrollIntoView(productsPage.searchProductBox);
        String searchProductName = MockDataForUI.getStaticInstance().getSearchProductName();
        productsPage.searchProductBox.sendKeys(searchProductName);
        productsPage.submitSearchBtn.click();
    }

    @Then("verify that SEARCHED PRODUCTS is visible")
    public void verify_that_searched_products_is_visible() {
        searchedProductsPage = (AutomationExerciseSearchedProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.SearchedProductsPage);
        Driver.waitForVisibility(searchedProductsPage.searchedProductsH2, 3);
        Assert.assertTrue(searchedProductsPage.searchedProductsH2.isDisplayed());
    }

    @Then("verify that all products related to search are visible")
    public void verify_that_all_products_related_to_search_are_visible() {
        searchedProductsPage = (AutomationExerciseSearchedProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.SearchedProductsPage);
        Driver.waitForVisibility(searchedProductsPage.searchedProductsH2, 3);
        List<WebElement> allFoundProductNames = searchedProductsPage.allProductNames;
        String searchedItem = MockDataForUI.getStaticInstance().getSearchProductName();
        boolean isAllIncluded=true;
        for(WebElement w:allFoundProductNames){
            if (!w.getText().toUpperCase().contains(searchedItem.toUpperCase())){
                isAllIncluded=false;break;
            }
        }
        Assert.assertTrue(isAllIncluded);
    }

    @When("add all searched products to cart")
    public void add_all_searched_products_to_cart() {
        searchedProductsPage = (AutomationExerciseSearchedProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.SearchedProductsPage);
        List<WebElement> allFoundProductsAddToCartBtns = searchedProductsPage.allProductsAddToCartBtns;
        List<WebElement> allFoundProductNames = searchedProductsPage.allProductNames;
        Driver.scrollIntoView(searchedProductsPage.searchedProductsH2);
        Driver.clickPageDown();
        WebElement w;
        WebElement wt;
        for(int i=0;i<allFoundProductsAddToCartBtns.size();i++)
        {
            w = allFoundProductsAddToCartBtns.get(i);
            wt = allFoundProductNames.get(i);
            Driver.scrollIntoView(w);
            Driver.clickByHoverOver(w);
            //MockDataForUI.addProductInCart(wt.getText());
            productNamesInCart.add(wt.getText());
            Driver.waitAndClick(searchedProductsPage.continueShoppingBtn, 2);
        }

    }
    /*
     Then click cart button on home page
     */
    @Then("verify that all searched products added into cart")
    public void verify_that_all_searched_products_added_into_cart() {
        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);
        List<WebElement> productsInCartDescriptions = viewCartPage.productsInCartDescriptions;
        //List<String> productNamesInCart = MockDataForUI.getProductsInCart();
        Assert.assertEquals(productNamesInCart.size(),
                productsInCartDescriptions.size());
        List<String> collect = productsInCartDescriptions.stream()
                .map(t -> t.getText())
                .collect(Collectors.toList());

        boolean isIn = false;
        for (String w:productNamesInCart){
            for(String t:collect){
                if (t.contains(w)) {
                    isIn= true;break;
                }
            }
            if (!isIn){
                break;
            }
        }
        Assert.assertTrue(isIn);
    }
    /*
     Then enter correct email and password
     And verify that Logged in as username is visible
     And click cart button on home page
     */
    @Then("verify that all searched products added into cart after login as well")
    public void verify_that_all_searched_products_added_into_cart_after_login_as_well() {
        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);
        List<WebElement> productsInCartDescriptions = viewCartPage.productsInCartDescriptions;
        //List<String> productNamesInCart = MockDataForUI.getProductsInCart();
        Assert.assertEquals(productNamesInCart.size(),
                productsInCartDescriptions.size());
        List<String> collect = productsInCartDescriptions.stream()
                .map(t -> t.getText())
                .collect(Collectors.toList());

        boolean isIn = false;
        for (String w:productNamesInCart){
            for(String t:collect){
                if (t.contains(w)) {
                    isIn= true;break;
                }
            }
            if (!isIn){
                break;
            }
        }
        Assert.assertTrue(isIn);
    }

}
