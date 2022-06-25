package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import pages.AutomationExerciseProductDetailsPage;
import testdata.MockDataForUI;
import utilities.Driver;

public class TestCase21StepDefs {

    /*
    Given user launches browser
    And navigate to url
    When click on Products button
    Then verify user is navigated to ALL PRODUCTS page successfully
    And click on View Product of first product
    */
    AutomationExerciseProductDetailsPage productDetailsPage;
    @Then("verify that WRITE YOUR REVIEW is visible")
    public void verify_that_write_your_review_is_visible() {
        productDetailsPage = (AutomationExerciseProductDetailsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductDetailsPage);
        Driver.scrollIntoView(productDetailsPage.writeYourReviewLink);
        Assert.assertTrue(productDetailsPage.writeYourReviewLink.isDisplayed());
        //Driver.clickPageDown();
    }
    @When("review name, email and review text on product details page")
    public void review_name_email_and_review_text_on_product_details_page() {
        productDetailsPage = (AutomationExerciseProductDetailsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductDetailsPage);
        MockDataForUI mockDataForUI= MockDataForUI.getStaticInstance();
        productDetailsPage.reviewName.sendKeys(mockDataForUI.getFirstName());
        productDetailsPage.reviewEmail.sendKeys(mockDataForUI.getEmail());
        productDetailsPage.reviewMessage.sendKeys(mockDataForUI.getContactMessage());
    }
    @When("click review submit button on product details page")
    public void click_review_submit_button_on_product_details_page() {
        productDetailsPage = (AutomationExerciseProductDetailsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductDetailsPage);
        productDetailsPage.reviewSubmitBtn.click();
    }
    @Then("verify that success message Thank you for your review")
    public void verify_that_success_message_thank_you_for_your_review() {
        productDetailsPage = (AutomationExerciseProductDetailsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ProductDetailsPage);
        WebElement w = Driver.waitForVisibility(productDetailsPage.successOfReviewSendMessage,
                3);
        Assert.assertNotNull(w);
    }
}
