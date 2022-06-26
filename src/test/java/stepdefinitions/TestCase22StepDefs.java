package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExerciseHomePage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import pages.AutomationExerciseViewCartPage;
import utilities.Driver;

import java.util.List;

public class TestCase22StepDefs {
    /*
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
    When Add products to cart
    And click cart button after adding products on home page
    Then verify that cart page is displayed
    And click X button corresponding to particular product on view cart page
    Then verify that product is removed from the cart on view cart page
    * */
    private AutomationExerciseHomePage homePage;
    private AutomationExerciseViewCartPage viewCartPage;

    @When("scroll bottom to the Recommended Items on main page")
    public void scroll_bottom_to_the_recommended_items_on_main_page() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);

    }
    @When("click on Add To Cart on visible Recommended product")
    public void click_on_add_to_cart_on_visible_recommended_product() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        List<WebElement> recommendedItemAddBtns = homePage.RecommendedItemAddBtns;
        int index=0;
        WebElement selectedItemAddBtn=recommendedItemAddBtns.get(0);
        for(WebElement w:recommendedItemAddBtns){
            if (w.isDisplayed()){
                selectedItemAddBtn = w; break;
            }
            index ++;
        }
        WebElement selectedItemNames = homePage.RecommendedItemNames.get(index);
        selectedItemAddBtn.click();
        homePage.getContextData().addContextData("addedItemName",selectedItemNames.getText());
    }
    @When("click View Cart button on modal")
    public void click_view_cart_button_on_modal() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Driver.waitForVisibility(homePage.modalViewCartLink, 3);
        homePage.modalViewCartLink.click();
    }
    @Then("verify that recommended product is displayed in cart page")
    public void verify_that_recommended_product_is_displayed_in_cart_page() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);

        Driver.waitForVisibility(viewCartPage.itemHeaderTr, 3);
        String addedProductName = (String) homePage.getContextData().
                getContextData("addedItemName");

        List<WebElement> productsInCartDescriptions = viewCartPage.productsInCartDescriptions;

        Assert.assertTrue(productsInCartDescriptions.size()==1);

        String description = productsInCartDescriptions.get(0).getText();

        Assert.assertTrue(description.toUpperCase().contains(addedProductName.toUpperCase()));

    }

}
