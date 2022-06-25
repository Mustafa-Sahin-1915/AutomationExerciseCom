package pages;

public enum AutomationExercisePagesEnum {

    BasePage("BasePage"),
    AccountCreatedPage("AccountCreatedPage"),
    AccountDeletePage("AccountDeletePage"),
    CheckOutPage("CheckOutPage"),
    ContactUsPage("ContactUsPage"),
    ContactUsSuccessPage("ContactUsSuccessPage"),
    EnterAccountInfoPage("EnterAccountInfoPage"),
    HomePage("HomePage"),
    LoginPage("LoginPage"),
    PaymentDone("PaymentDone"),
    PaymentPage("PaymentPage"),
    ProductDetailsPage("ProductDetailsPage"),
    ProductsPage("ProductsPage"),
    SearchedProductsPage("SearchedProductsPage"),
    TestCasesPage("TestCasesPage"),
    ViewCartPage("ViewCartPage"),
    CategoryProductsPage("CategoryProductsPage"),

    BrandProductsPage("BrandProductsPage");
    private String name;

    AutomationExercisePagesEnum(String name) {
        this.name = name;
    }
}
