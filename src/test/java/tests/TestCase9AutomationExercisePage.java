package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AutomationExerciseHomePage;
import utilities.ConfigReader;
import utilities.Driver;


public class TestCase9AutomationExercisePage {

    /*
Test Case 9.
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
     */
    @Test
    public void testCase9(){
       // 1. and 2
        Driver.getDriver().get(ConfigReader.getProperty("automationexercise_url"));
        //3
        AutomationExerciseHomePage automationExercisePage = new AutomationExerciseHomePage();
        Assert.assertTrue(automationExercisePage.productsLink.isDisplayed());
        //4
        automationExercisePage.productsLink.click();
        Assert.assertTrue(
                automationExercisePage.allProductsHeader.getText().
                        equalsIgnoreCase("ALL PRODUCTS"));

        //i am getting first products name to search later
        String firstProductName = automationExercisePage.productsFirstName.getText();

        automationExercisePage.searchBox.sendKeys(firstProductName);
        automationExercisePage.searchButton.click();

        Assert.assertTrue(automationExercisePage.searchedProductsHeader.getText().
                        equalsIgnoreCase("SEARCHED PRODUCTS"));

        boolean isAllincludeSearchInName=true;
        for(WebElement productName:automationExercisePage.productsNames){
            if (productName.getText().length()!=0 &&
                    !productName.getText().contains(firstProductName)){

                isAllincludeSearchInName = false;
                break;
            }
        }
        //at least there are one valid search result
        Assert.assertTrue(automationExercisePage.productsNames.
                stream().
                anyMatch(t->(t.getText().length()!=0
                          &&
                        t.getText().contains(firstProductName))));
        Assert.assertTrue(isAllincludeSearchInName);

    }

    @AfterMethod
    public void tearDownAfterMethod(){

    }
    @AfterClass
    public void tearDownAfterClass(){

        Driver.closeDriver();
    }
}
