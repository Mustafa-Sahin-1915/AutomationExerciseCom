package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExerciseProductsPage;
import pages.AutomationExerciseSearchedProductsPage;
import utilities.Driver;

import java.util.List;

public class TestCase9StepDefs {
    WebDriver driver;
    AutomationExerciseProductsPage productsPage;
    AutomationExerciseSearchedProductsPage searchedProductsPage;
    String searchedProductName;
    @When("enter {string} in search input and click search button")
    public void enter_in_search_input_and_click_search_button(String productName) {
        driver = Driver.getDriver();
        productsPage= new AutomationExerciseProductsPage();

        productsPage.searchProductBox.sendKeys(productName);
        searchedProductName = productName;
        productsPage.submitSearchBtn.click();

        searchedProductsPage = new AutomationExerciseSearchedProductsPage();
    }
    @Then("verify searched products is visible")
    public void verify_searched_products_is_visible() {
        Driver.waitForVisibility(searchedProductsPage.searchedProductsH2,10);
        Driver.scrollIntoView(searchedProductsPage.searchedProductsH2);
        Assert.assertTrue(searchedProductsPage.searchedProductsH2.isDisplayed());
    }
    @Then("verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
        Assert.assertTrue(searchedProductsPage.allProducts.size()>0);
        List<WebElement> searchedAndFoundProducts = searchedProductsPage.allProducts;
        WebElement productNameEl;
        String productName;
        for (WebElement w:searchedAndFoundProducts){
            productNameEl = w.findElement(By.cssSelector("p"));
            productName = productNameEl.getText();
            Assert.assertTrue(productName.toUpperCase().contains(searchedProductName.toUpperCase()));
        }
    }
}
