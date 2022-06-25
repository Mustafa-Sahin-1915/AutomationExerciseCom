package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import pages.AutomationExerciseViewCartPage;
import utilities.Driver;

import java.util.List;

public class TestCase17StepDefs {
    private AutomationExerciseViewCartPage viewCartPage;
    private int sizeOfdeleteBtns;
    @Then("click X button corresponding to particular product on view cart page")
    public void click_x_button_corresponding_to_particular_product_on_view_cart_page() {
        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);
        List<WebElement> productDeleteBtns = viewCartPage.productDeleteBtns;
        sizeOfdeleteBtns = productDeleteBtns.size();
        if (sizeOfdeleteBtns>0) {
            productDeleteBtns.get(0).click();
        }
    }
    @Then("verify that product is removed from the cart on view cart page")
    public void verify_that_product_is_removed_from_the_cart_on_view_cart_page() {
        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);
        List<WebElement> productDeleteBtns = viewCartPage.productDeleteBtns;
        if (productDeleteBtns.size()==1) {
            Driver.waitForVisibility(viewCartPage.emptyCartMsg, 5);
            Assert.assertTrue(viewCartPage.emptyCartMsg.isDisplayed());
        }else{
            Assert.assertTrue(productDeleteBtns.size()<sizeOfdeleteBtns);
        }
    }
}
