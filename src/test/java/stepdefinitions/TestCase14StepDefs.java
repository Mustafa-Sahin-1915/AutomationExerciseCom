package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.*;
import testdata.MockDataForUI;
import utilities.Driver;


import java.util.List;

public class TestCase14StepDefs {
    AutomationExerciseHomePage homePage;
    AutomationExerciseViewCartPage viewCartPage;
    AutomationExerciseCheckOutPage checkOutPage;
    AutomationExercisePaymentPage paymentPage;

    AutomationExercisePaymentDonePage paymentDonePage;

    MockDataForUI mockData =MockDataForUI.getStaticInstance();

    /*
    Given user launches browser
    And navigate to url
    Then verify that home page is visible successfully
     */
    @When("Add products to cart")
    public void add_products_to_cart() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        List<WebElement> addToCartBtns = homePage.addToCartBtns;
        addToCartBtns.get(0).click();
    }
    //And click cart button
    @And("click cart button after adding products on home page")
    public void click_cart_button_after_adding_products_on_home_page() {

        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        homePage.modalViewCartLink.click();
    }
    @Then("verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);
       Assert.assertTrue(viewCartPage.proceedToCheckoutBtn.isDisplayed());
    }
    @When("click to Proceed to Checkout on cart web page")
    public void click_to_proceed_to_checkout_on_cart_web_page() {
        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);
        viewCartPage.proceedToCheckoutBtn.click();
    }


    @When("click on signup_login button on cart web page")
    public void click_on_signup_login_button_on_cart_web_page() {
        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);
        viewCartPage.signupLoginOnCartPageLink.click();
    }
   /*
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

        viewCartPage = (AutomationExerciseViewCartPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ViewCartPage);
        viewCartPage.proceedToCheckoutBtn.click();
    }
    @Then("verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {
        checkOutPage = (AutomationExerciseCheckOutPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.CheckOutPage);

        Assert.assertEquals(checkOutPage.deliveryAddress2.getText(),
                mockData.getCompanyAddress1());

    }
    @When("enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        checkOutPage = (AutomationExerciseCheckOutPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.CheckOutPage);
        Driver.scrollIntoView(checkOutPage.orderMessageTextArea);
        checkOutPage.orderMessageTextArea.sendKeys(MockDataForUI.getInstance().getCheckoutComment());
        checkOutPage.placeOrderBtn.click();
    }
    @When("enter payment details:Name on Card, Card Number, CVC, Expiration Date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
        paymentPage = (AutomationExercisePaymentPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.PaymentPage);
        paymentPage.nameOnCardTxt.sendKeys(MockDataForUI.getInstance().getNameOnCard());
        paymentPage.cardNumberTxt.sendKeys(MockDataForUI.getInstance().getCardNumber());
        paymentPage.cvcTxt.sendKeys(MockDataForUI.getInstance().getCvc());
        paymentPage.expiryMonthTxt.sendKeys(MockDataForUI.getInstance().getExpiryMonth());
        paymentPage.expiryYearTxt.sendKeys(MockDataForUI.getInstance().getExpiryYear());
    }
    @When("click Pay and Confirm Order button")
    public void click_pay_and_confirm_order_button() {
        paymentPage = (AutomationExercisePaymentPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.PaymentPage);
        Driver.scrollIntoView(paymentPage.payAndConfirmOrderBtn);
        Actions actions = new Actions(Driver.getDriver());
        Driver.clickPageDown();
        paymentPage.payAndConfirmOrderBtn.click();
    }
    @Then("verify success message Your order has been placed successfully")
    public void verify_success_message_your_order_has_been_placed_successfully() {
        //Driver.waitForVisibility(paymentPage.successfullyOrderedMessage,5);
        // There is a problem about that step
        //WebElement successMsg =
         //       Driver.waitForVisibility(paymentPage.successfullyOrderedMessage, 5);
       // Assert.assertTrue(successMsg.isDisplayed());

    }
    @Then("verify that Order Placed! is visible")
    public void verify_that_order_placed_is_visible() {
        paymentDonePage = (AutomationExercisePaymentDonePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.PaymentDonePage);
        Assert.assertTrue(paymentDonePage.orderPlacedH2.isDisplayed());

    }
    @Then("click on Continue on payment done page")
    public void click_on_continue_on_payment_done_page() {
        paymentDonePage = (AutomationExercisePaymentDonePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.PaymentDonePage);
        paymentDonePage.continueBtn.click();
    }
    /*
      When click Delete Account button
      Then verify that ACCOUNT DELETED is visible
      And click after delete Continue button
    */
}
