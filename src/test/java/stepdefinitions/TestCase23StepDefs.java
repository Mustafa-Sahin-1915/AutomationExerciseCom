package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AutomationExerciseCheckOutPage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import testdata.MockDataForUI;

public class TestCase23StepDefs {
    /*
        Given user launches browser
        And navigate to url
        Then verify that home page is visible successfully
        When click signup button on home page
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
        When click on Products button
        And hover over first product and click Add to cart
        And click View Cart button on modal
        Then verify that cart page is displayed
        And click proceed to checkout button
        Then verify that the delivery address is same address filled at the time registration of account
        And verify that the billing address is same address filled at the time registration of account
        And click Delete Account button
        Then verify that ACCOUNT DELETED is visible
        And click after delete Continue button
     */
    AutomationExerciseCheckOutPage checkOutPage;
    @Then("verify that the delivery address is same address filled at the time registration of account")
    public void verify_that_the_delivery_address_is_same_address_filled_at_the_time_registration_of_account() {
        checkOutPage = (AutomationExerciseCheckOutPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.CheckOutPage);
        MockDataForUI mockData = MockDataForUI.getStaticInstance();
        Assert.assertEquals(checkOutPage.deliveryAddress2.getText(),
                mockData.getCompanyAddress1());
    }

    @Then("verify that the billing address is same address filled at the time registration of account")
    public void verify_that_the_billing_address_is_same_address_filled_at_the_time_registration_of_account() {
        checkOutPage = (AutomationExerciseCheckOutPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.CheckOutPage);
        MockDataForUI mockData = MockDataForUI.getStaticInstance();
        Assert.assertEquals(checkOutPage.billingAddress2.getText(),
                mockData.getCompanyAddress1());
    }
}
