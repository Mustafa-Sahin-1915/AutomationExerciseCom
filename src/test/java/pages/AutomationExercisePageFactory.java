package pages;

import java.util.HashMap;

public class AutomationExercisePageFactory {
    private static HashMap<String, AutomationExerciseBasePage> pages = new HashMap<>();

    public static AutomationExerciseBasePage getPage(AutomationExercisePagesEnum page){
        AutomationExerciseBasePage pageV=null;
        switch (page){
            case BasePage:pageV = new AutomationExerciseBasePage();break;
            case LoginPage:pageV = new AutomationExerciseLoginPage();break;
            case HomePage:pageV = new AutomationExerciseHomePage();break;
            case PaymentPage: pageV = new AutomationExercisePaymentPage();break;
            case PaymentDone:pageV = new AutomationExercisePaymentDonePage();break;
            case ProductsPage:pageV = new AutomationExerciseProductsPage();break;
            case CheckOutPage:pageV = new AutomationExerciseCheckOutPage();break;
            case ContactUsPage:pageV = new AutomationExerciseContactUsPage();break;
            case ViewCartPage:pageV = new AutomationExerciseViewCartPage();break;
            case TestCasesPage:pageV = new AutomationExerciseTestCasesPage();break;
            case AccountDeletePage:pageV = new AutomationExerciseAccountDeletePage();break;
            case AccountCreatedPage:pageV = new AutomationExerciseAccountCreatedPage();break;
            case ProductDetailsPage:pageV = new AutomationExerciseProductDetailsPage();break;
            case ContactUsSuccessPage:pageV = new AutomationExerciseContactUsSuccessPage();break;
            case EnterAccountInfoPage:pageV=new AutomationExerciseEnterAccountInfoPage();break;
            case SearchedProductsPage:pageV = new AutomationExerciseSearchedProductsPage();break;
            case CategoryProductsPage:pageV = new AutomationExerciseCategoryProductsPage();break;
            default:pageV = null;
        }
        return pageV;
    }

    public static AutomationExerciseBasePage getPageFromPoll(AutomationExercisePagesEnum page){
        AutomationExerciseBasePage pageV = null;
        pageV = pages.get(page.name());
        if (pageV==null){
            pages.put(page.name(), AutomationExercisePageFactory.getPage(page));
        }
        return pageV;
    }
}
