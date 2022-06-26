package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

public class AutomationExerciseBrandProductsPage extends AutomationExerciseBasePage{

    public AutomationExerciseBrandProductsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public AutomationExerciseBrandProductsPage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement brandProductH2;
}
