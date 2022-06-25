package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import testdata.MockDataForUI;
import utilities.Driver;

public class TestCase6StepDefs {
    AutomationExerciseHomePage homePage;
    AutomationExerciseContactUsPage contactUsPage;
    MockDataForUI mockDataForUI = MockDataForUI.getInstance();
    AutomationExerciseContactUsSuccessPage contactUsSuccessPage;
    WebDriver driver = Driver.getDriver();
    @When("click on Contact Us button")
    public void click_on_contact_us_button() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
       homePage.contactUsLink.click();
    }
    @Then("verify GET IN TOUCH is visible")
    public void verify_get_in_touch_is_visible() {
        contactUsPage = (AutomationExerciseContactUsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ContactUsPage);
        Assert.assertTrue(contactUsPage.getInTouchH2.isDisplayed());
    }
    @When("Enter name, email, subject and message")
    public void enter_name_email_subject_and_message() {
        contactUsPage = (AutomationExerciseContactUsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ContactUsPage);
        contactUsPage.contactFormName.sendKeys(mockDataForUI.getFirstName());
        contactUsPage.contactFormEmail.sendKeys(mockDataForUI.getEmail());
        contactUsPage.contactFormSubject.sendKeys(mockDataForUI.getContactSubject());
        contactUsPage.contactFormMessage.sendKeys(mockDataForUI.getContactMessage());

    }
    @When("upload file")
    public void upload_file() {
        contactUsPage = (AutomationExerciseContactUsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ContactUsPage);
        String userHomePath = System.getProperty("user.home");
        String picturesPath = userHomePath+"\\OneDrive\\Pictures";//for one drive
        String fileName = "sample.png";
        String uploadedFilePath = picturesPath+"\\"+fileName;
        contactUsPage.contactFormUploadFile.sendKeys(uploadedFilePath);
    }
    @When("click submit button")
    public void click_submit_button() {
        contactUsPage = (AutomationExerciseContactUsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ContactUsPage);
        contactUsPage.contactFormSubmitBtn.click();
    }
    @When("click OK button")
    public void click_ok_button() {
        driver.switchTo().alert().accept();
    }
    @Then("verify success message Success.Your details have been submitted successfully is visible")
    public void verify_success_message_success_your_details_have_been_submitted_successfully_is_visible() {
        contactUsSuccessPage = (AutomationExerciseContactUsSuccessPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ContactUsSuccessPage);
        //String statusMessage = contactUsSuccessPage.contactUsSuccessMsg.getText();
        //Assert.assertEquals(statusMessage, "Success! Your details have been submitted successfully.");
        Assert.assertTrue(contactUsSuccessPage.contactUsSuccessMsg.isDisplayed());
    }
    @Then("click Home button and verify that landed to home page successfully")
    public void click_home_button_and_verify_that_landed_to_home_page_successfully() {
        contactUsSuccessPage = (AutomationExerciseContactUsSuccessPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.ContactUsSuccessPage);
        contactUsSuccessPage.contactUsHomeBtn.click();
    }

}
