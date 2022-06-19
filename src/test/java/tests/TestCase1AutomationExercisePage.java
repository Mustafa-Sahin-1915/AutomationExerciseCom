package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AutomationExerciseHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase1AutomationExercisePage {
    /*
    Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    */
    @Test
    public void testCase1() {
        Driver.getDriver().get(ConfigReader.getProperty("automationexercise_url"));
        AutomationExerciseHomePage automationExercisePage = new AutomationExerciseHomePage();
        //assert page is visible
        Assert.assertTrue(automationExercisePage.signupLoginLink.isDisplayed());
        automationExercisePage.signupLoginLink.click();
    }
    @AfterMethod
    public void tearDownAfterMethod(){

    }
    @AfterClass
    public void tearDownAfterClass(){

        Driver.closeDriver();
    }
}
