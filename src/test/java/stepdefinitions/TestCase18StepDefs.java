package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AutomationExerciseCategoryProductsPage;
import pages.AutomationExerciseHomePage;
import pages.AutomationExercisePageFactory;
import pages.AutomationExercisePagesEnum;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestCase18StepDefs {
    AutomationExerciseHomePage homePage;
    AutomationExerciseCategoryProductsPage categoryProductsPage;
    @Then("verify that categories are visible on left side bar")
    public void verify_that_categories_are_visible_on_left_side_bar() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Assert.assertTrue(homePage.leftSideBarCategoryH2.isDisplayed());
    }
    @When("click women category on left side bar")
    public void click_women_category_on_left_side_bar() {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        Driver.scrollIntoView(homePage.womenCategoryLeftSideBar);
        Driver.waitAndClick(homePage.womenCategoryLeftSideBar, 1);
    }
    @When("click on {string} sub category of {string} category")
    public void click_on_sub_category_of_category(String subCategory, String category) {
        homePage = (AutomationExerciseHomePage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.HomePage);
        WebElement categoryLink = homePage.getCategoryByVisibleName(category);
        Driver.scrollIntoView(categoryLink);
        //categoryLink.click();

        WebElement subCategoryLink = homePage.getCategoryByVisibleName(subCategory);
        //System.out.println(subCategoryLink.getText());
        ReusableMethods.waitForClickablility(subCategoryLink, 3);
        subCategoryLink.click();
    }
    @Then("verify that {string} sub category products page is displayed")
    public void verify_that_sub_category_products_page_is_displayed(String subCategory) {
        categoryProductsPage = (AutomationExerciseCategoryProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.CategoryProductsPage);
        Driver.wait(2);
        Driver.waitForVisibility(categoryProductsPage.categoryProductH2, 5);
        String categoryProductH2Str = categoryProductsPage.categoryProductH2.getText().toUpperCase();
        Assert.assertTrue(categoryProductH2Str.contains(subCategory.toUpperCase()));

    }
    @Then("verift that {string} text on {string} sub category products page")
    public void verift_that_text_on_sub_category_products_page(String subCategory, String category) {
        categoryProductsPage = (AutomationExerciseCategoryProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.CategoryProductsPage);
        String categoryProductH2Str = categoryProductsPage.categoryProductH2.getText().toUpperCase();
        Assert.assertTrue(categoryProductH2Str.equalsIgnoreCase(subCategory));
    }
    @Then("click on any {string} link of {string} category")
    public void click_on_any_link_of_category(String subCategory, String category) {
        categoryProductsPage = (AutomationExerciseCategoryProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.CategoryProductsPage);
        WebElement categoryLink = categoryProductsPage.getCategoryByVisibleName(category);
        Driver.scrollIntoView(categoryLink);
        Driver.clickByHoverOver(categoryLink);

        WebElement subCategoryLink = categoryProductsPage.getCategoryByVisibleName(subCategory);
        //System.out.println(subCategoryLink.getText());
        ReusableMethods.waitForClickablility(subCategoryLink, 3);
        Driver.clickByHoverOver(subCategoryLink);

    }
    @Then("verify that user nagivated to {string} link of {string} category")
    public void verify_that_user_nagivated_to_link_of_category(String subCategory, String category) {
        categoryProductsPage = (AutomationExerciseCategoryProductsPage) AutomationExercisePageFactory.
                getPage(AutomationExercisePagesEnum.CategoryProductsPage);
        String categoryProductH2Str = categoryProductsPage.categoryProductH2.getText().toUpperCase();
        Assert.assertTrue(categoryProductH2Str.contains(subCategory.toUpperCase()));



    }
}
