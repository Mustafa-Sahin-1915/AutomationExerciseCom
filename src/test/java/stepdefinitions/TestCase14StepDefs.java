package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExerciseCheckOutPage;
import pages.AutomationExerciseHomePage;
import pages.AutomationExerciseLoginPage;
import pages.AutomationExerciseViewCartPage;
import testdata.MockDataForUI;


import java.util.List;

public class TestCase14StepDefs {
    AutomationExerciseHomePage homePage;
    AutomationExerciseViewCartPage viewCartPage;
    AutomationExerciseCheckOutPage checkOutPage;

    /*
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
     */
    @When("Add products to cart")
    public void add_products_to_cart() {
        homePage = new AutomationExerciseHomePage();
        List<WebElement> addToCartBtns = homePage.addToCartBtns;
        addToCartBtns.get(0).click();
    }
    //And click cart button
    @Then("verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
       viewCartPage = new AutomationExerciseViewCartPage();
       Assert.assertTrue(viewCartPage.proceedToCheckoutBtn.isDisplayed());
    }
    @When("click to Proceed to Checkout on cart web page")
    public void click_to_proceed_to_checkout_on_cart_web_page() {
        viewCartPage.proceedToCheckoutBtn.click();
    }
/*
    And click on signup_login button
    Then verify New User Signup is visible
    When enter name and email address
    And click signup button
    Then verify ENTER ACCOUNT INFORMATION is visible
    When fill the details, title, name, email, password, date of birth
    And select checkbox sign up for our newsletter
    And fill the details first name, last name, company, address, address2, country, state, city, zipcode, mobile number
    And click create account button
    Then verify that ACCOUNT CREATED is visible
    When click Continue button
    Then verify that Logged in as username is visible
    When click cart button
 */
    @When("click proceed to checkout button")
    public void click_proceed_to_checkout_button() {
        viewCartPage.proceedToCheckoutBtn.click();
    }
    @Then("verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {
        checkOutPage = new AutomationExerciseCheckOutPage();
        Assert.assertEquals(checkOutPage.deliveryAddress1,
                MockDataForUI.getInstance().getCompanyAddress1());

    }
    @When("enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {

    }
    @When("enter payment details:Name on Card, Card Number, CVC, Expiration Date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {

    }
    @When("click Pay and Confirm Order button")
    public void click_pay_and_confirm_order_button() {

    }
    @Then("verify success message Your order has been placed successfully")
    public void verify_success_message_your_order_has_been_placed_successfully() {

    }
    /*
    When click Delete Account button
    Then verify that ACCOUNT DELETED is visible
    And click after delete Continue button
     */
}
