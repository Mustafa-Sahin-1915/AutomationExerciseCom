package pages;

import testdata.ContextDataMap;

import java.util.HashMap;

public class AutomationExercisePageFactory {
    private static HashMap<String, AutomationExerciseBasePage> pages = new HashMap<>();
    private static ContextDataMap contextDataMap = new ContextDataMap();
    public static AutomationExerciseBasePage getPage(AutomationExercisePagesEnum page) {
        if (contextDataMap==null){
            contextDataMap = new ContextDataMap();
        }
        AutomationExerciseBasePage pageV = null;
        switch (page) {
            case BasePage:
                pageV = new AutomationExerciseBasePage(contextDataMap);
                break;
            case LoginPage:
                pageV = new AutomationExerciseLoginPage(contextDataMap);
                break;
            case HomePage:
                pageV = new AutomationExerciseHomePage(contextDataMap);
                break;
            case PaymentPage:
                pageV = new AutomationExercisePaymentPage(contextDataMap);
                break;
            case PaymentDonePage:
                pageV = new AutomationExercisePaymentDonePage(contextDataMap);
                break;
            case ProductsPage:
                pageV = new AutomationExerciseProductsPage(contextDataMap);
                break;
            case CheckOutPage:
                pageV = new AutomationExerciseCheckOutPage(contextDataMap);
                break;
            case ContactUsPage:
                pageV = new AutomationExerciseContactUsPage(contextDataMap);
                break;
            case ViewCartPage:
                pageV = new AutomationExerciseViewCartPage(contextDataMap);
                break;
            case TestCasesPage:
                pageV = new AutomationExerciseTestCasesPage(contextDataMap);
                break;
            case AccountDeletePage:
                pageV = new AutomationExerciseAccountDeletePage(contextDataMap);
                break;
            case AccountCreatedPage:
                pageV = new AutomationExerciseAccountCreatedPage(contextDataMap);
                break;
            case ProductDetailsPage:
                pageV = new AutomationExerciseProductDetailsPage(contextDataMap);
                break;
            case ContactUsSuccessPage:
                pageV = new AutomationExerciseContactUsSuccessPage(contextDataMap);
                break;
            case EnterAccountInfoPage:
                pageV = new AutomationExerciseEnterAccountInfoPage(contextDataMap);
                break;
            case SearchedProductsPage:
                pageV = new AutomationExerciseSearchedProductsPage(contextDataMap);
                break;
            case CategoryProductsPage:
                pageV = new AutomationExerciseCategoryProductsPage(contextDataMap);
                break;
            case BrandProductsPage:
                pageV = new AutomationExerciseBrandProductsPage(contextDataMap);
                break;
            default:
                pageV = null;
        }
        return pageV;
    }

    public static AutomationExerciseBasePage getPageFromPool(AutomationExercisePagesEnum page) {
        AutomationExerciseBasePage pageV = null;
        pageV = pages.get(page.name());
        if (pageV == null) {
            pages.put(page.name(), AutomationExercisePageFactory.getPage(page));
        }
        return pageV;
    }
}
