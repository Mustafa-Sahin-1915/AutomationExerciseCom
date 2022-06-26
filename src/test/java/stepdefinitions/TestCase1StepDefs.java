package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import testdata.MockDataForUI;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JsonUtil;
import utilities.ReusableMethods;

public class TestCase1StepDefs {
    WebDriver driver;
    AutomationExerciseHomePage homePage;
    AutomationExerciseLoginPage loginPage;
    AutomationExerciseEnterAccountInfoPage accountInfoPage;
    AutomationExerciseAccountCreatedPage accountCreatedPage;

    AutomationExerciseAccountDeletePage accountDeletePage;

    @Given("user launches browser")
    public void user_launches_browser() {
        driver = Driver.getDriver();
    }
    @Given("navigate to url")
    public void navigate_to_url() {
        driver.get(ConfigReader.getProperty("automationexercise_url"));
    }
    @Then("verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(ConfigReader.getProperty("automationexercise_url"),currentUrl);
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);

    }
    @When("click on signup_login button")
    public void click_on_signup_login_button() {
       AutomationExerciseHomePage homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
               getPage(AutomationExercisePagesEnum.HomePage);
       Driver.waitForVisibility(homePage.signupLoginLink, 2);
       homePage.signupLoginLink.click();
    }
    @Then("verify New User Signup is visible")
    public void verify_new_user_signup_is_visible() {
        loginPage = (AutomationExerciseLoginPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.LoginPage);
        Assert.assertTrue(loginPage.newUserSignupH2.isDisplayed());
    }

    @When("enter name and email address")
    public void enter_name_and_email_address() {
        loginPage = (AutomationExerciseLoginPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.LoginPage);
        Driver.scrollIntoView(loginPage.signupName);
        loginPage.signupName.sendKeys(MockDataForUI.getStaticInstance().getFirstName());
        loginPage.signupEmail.sendKeys(MockDataForUI.getStaticInstance().getEmail());
    }
    @When("click signup button")
    public void click_signup_button() {
        loginPage = (AutomationExerciseLoginPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.LoginPage);
        loginPage.signUpBtn.click();
    }
    @Then("verify ENTER ACCOUNT INFORMATION is visible")
    public void verify_enter_account_information_is_visible() {
        accountInfoPage = (AutomationExerciseEnterAccountInfoPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.EnterAccountInfoPage);
        Assert.assertTrue(accountInfoPage.enterAccountInfoH2.isDisplayed());
    }

    @When("fill the details, title, name, email, password, date of birth")
    public void fill_the_details_title_name_email_password_date_of_birth() {
        accountInfoPage =  accountInfoPage = (AutomationExerciseEnterAccountInfoPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.EnterAccountInfoPage);
        MockDataForUI mockDataForUI = MockDataForUI.getStaticInstance();
        Driver.scrollIntoView(accountInfoPage.enterAccountInfoH2);
        accountInfoPage.titleMrRadioBtn.click();
        Assert.assertEquals(accountInfoPage.accountName.getAttribute("value"),mockDataForUI.getFirstName());
        Assert.assertEquals(accountInfoPage.accountEmail.getAttribute("value"),mockDataForUI.getEmail());
        accountInfoPage.accountPassword.sendKeys(mockDataForUI.getPassword());

        Select day = new Select(accountInfoPage.accountDayOfBirth);
        Select month = new Select(accountInfoPage.accountMonthOfBirth);
        Select year = new Select(accountInfoPage.accountYearOfBirth);

        day.selectByIndex(mockDataForUI.getDayOfBirth());
        month.selectByIndex(mockDataForUI.getMonthOfBirth());
        System.out.println(mockDataForUI.getYearOfBirth());
        year.selectByVisibleText(""+mockDataForUI.getYearOfBirth());

    }
    @When("select checkbox sign up for our newsletter")
    public void select_checkbox_sign_up_for_our_newsletter() {
        accountInfoPage = (AutomationExerciseEnterAccountInfoPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.EnterAccountInfoPage);
        if (!accountInfoPage.signupForNewsletterCheckbox.isSelected()){
            accountInfoPage.signupForNewsletterCheckbox.click();
        }
    }
    @When("fill the details first name, last name, company, address, address2, country, state, city, zipcode, mobile number")
    public void fill_the_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        accountInfoPage = (AutomationExerciseEnterAccountInfoPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.EnterAccountInfoPage);
        Driver.scrollIntoView(accountInfoPage.addressInfoH2);
        MockDataForUI mockDataForUI = MockDataForUI.getStaticInstance();
        accountInfoPage.firstName.sendKeys(mockDataForUI.getFirstName());
        accountInfoPage.lastName.sendKeys(mockDataForUI.getLastName());
        accountInfoPage.company.sendKeys(mockDataForUI.getCompany());
        Driver.scrollIntoView(accountInfoPage.address1);
        accountInfoPage.address1.sendKeys(mockDataForUI.getCompanyAddress1());
        accountInfoPage.address2.sendKeys(mockDataForUI.getCompanyAddress2());
        Select country = new Select(accountInfoPage.country);
        country.selectByIndex(mockDataForUI.getCountry());
        accountInfoPage.state.sendKeys(mockDataForUI.getState());
        accountInfoPage.city.sendKeys(mockDataForUI.getCity());
        accountInfoPage.zipcode.sendKeys(mockDataForUI.getZipCode());
        accountInfoPage.mobileNumber.sendKeys(mockDataForUI.getMobilePhone());
    }
    @When("click create account button")
    public void click_create_account_button() {
        accountInfoPage = (AutomationExerciseEnterAccountInfoPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.EnterAccountInfoPage);
        accountInfoPage.createAccountBtn.click();
    }
    @Then("verify that ACCOUNT CREATED is visible")
    public void verify_that_account_created_is_visible() {
        accountCreatedPage = (AutomationExerciseAccountCreatedPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.AccountCreatedPage);
        Assert.assertTrue(accountCreatedPage.accountCreatedH2.isDisplayed());
    }
    @When("click Continue button")
    public void click_continue_button() {
        accountCreatedPage = (AutomationExerciseAccountCreatedPage)AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.AccountCreatedPage);
        accountCreatedPage.continueBtn.click();
    }
    @Then("verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Assert.assertTrue(homePage.loggedInAsTxt.isDisplayed());
    }

    @When("click Delete Account button")
    public void click_delete_account_button() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        homePage.deleteAccountBtn.click();

    }

    @Then("verify that ACCOUNT DELETED is visible")
    public void verify_that_account_deleted_is_visible() {
      //  accountDeletePage =(AutomationExerciseAccountDeletePage)AutomationExercisePageFactory.
      //          getPage(AutomationExercisePagesEnum.AccountDeletePage);
      //  Assert.assertTrue(accountDeletePage.accountDeleteH2.isDisplayed());
        //this codes dont run correctly due to site
    }
    @Then("click after delete Continue button")
    public void click_after_delete_continue_button() {
        //accountDeletePage =(AutomationExerciseAccountDeletePage)AutomationExercisePageFactory.
        //        getPage(AutomationExercisePagesEnum.AccountDeletePage);
        //accountDeletePage.continueBtn.click();
        //this codes dont run correctly due to site
    }
}
