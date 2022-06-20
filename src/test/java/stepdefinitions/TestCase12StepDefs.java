package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExerciseProductsPage;
import pages.AutomationExerciseViewCartPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCase12StepDefs {
    private AutomationExerciseProductsPage productsPage;
    private WebDriver driver;
    private AutomationExerciseViewCartPage viewCartPage;

    private List<Map<String,String>> addedProducts = new ArrayList<>();


    @When("hover over first product and click Add to cart")
    public void hover_over_first_product_and_click_add_to_cart() {
        productsPage = new AutomationExerciseProductsPage();
        WebElement product = productsPage.getFirstProduct();
        Driver.scrollIntoView(product);
        ReusableMethods.hover(product);
        WebElement addToCart = productsPage.firstProductAddToCartOverlay;
        ReusableMethods.hover(addToCart);
        Map<String,String> productDescription = new HashMap<>();
        //name, prices, quantity and total price
        String nameOfProduct = product.findElement(By.cssSelector("p")).getText();
        String priceOfProduct = product.findElement(By.cssSelector("h2")).getText();
        productDescription.put("name",nameOfProduct);
        productDescription.put("price",priceOfProduct);
        addedProducts.add(productDescription);
        addToCart.click();
    }
    @When("click Continue Shopping button")
    public void click_continue_shopping_button() {
        productsPage.continueShoppingBtn.click();
    }
    @When("Hover over second product and click Add to cart")
    public void hover_over_second_product_and_click_add_to_cart() {
        WebElement product = productsPage.getSecondProduct();
        Driver.scrollIntoView(product);
        ReusableMethods.hover(product);
        WebElement addToCart = productsPage.secondProductAddToCartOverlay;
        ReusableMethods.hover(addToCart);
        Map<String,String> productDescription = new HashMap<>();
        //name, prices, quantity and total price
        String nameOfProduct = product.findElement(By.cssSelector("p")).getText();
        String priceOfProduct = product.findElement(By.cssSelector("h2")).getText();
        productDescription.put("name",nameOfProduct);
        productDescription.put("price",priceOfProduct);
        addedProducts.add(productDescription);
        addToCart.click();
    }
    @When("click View Cart button")
    public void click_view_cart_button() {
        productsPage = new AutomationExerciseProductsPage();
        Driver.waitAndClick(productsPage.viewCartModalBtn,2);
        viewCartPage = new AutomationExerciseViewCartPage();
    }
    @Then("verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        Driver.waitForVisibility(viewCartPage.proceedToCheckoutBtn,5);
        Driver.scrollIntoView(viewCartPage.proceedToCheckoutBtn);
        Assert.assertTrue(viewCartPage.addedProductsInCart.size()==2);
    }
    @Then("verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() {
        List<WebElement> addedProductsInCart= viewCartPage.addedProductsInCart;
        WebElement elInCart;
        System.out.println(addedProductsInCart.size());
        for (int i = 0; i < addedProductsInCart.size(); i++) {
            elInCart = addedProductsInCart.get(i);
            String name = elInCart.findElement(By.xpath("td[2]")).getText();
            String price = elInCart.findElement(By.xpath("td[3]")).getText();
            String quantity = elInCart.findElement(By.xpath("td[4]")).getText();
            String total = elInCart.findElement(By.xpath("td[5]")).getText();
            String addedName = addedProducts.get(i).get("name");
            String addedPrice = addedProducts.get(i).get("price");
            Assert.assertTrue(name.toUpperCase().contains(addedName.toUpperCase()));
            Assert.assertEquals(price,addedPrice);
            Assert.assertEquals(price,total);
        }
    }
}
