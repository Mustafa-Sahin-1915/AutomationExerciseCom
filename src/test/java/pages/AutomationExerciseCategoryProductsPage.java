package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.ContextDataMap;
import utilities.Driver;

import java.util.List;

public class AutomationExerciseCategoryProductsPage extends AutomationExerciseBasePage{

    public AutomationExerciseCategoryProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public AutomationExerciseCategoryProductsPage(ContextDataMap contextData) {
        super(contextData);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement categoryProductH2;
    @FindBy(xpath ="//div[@id='accordian']//a" )
    public List<WebElement> accordionAlinks;

    @FindBy(xpath = "//div[@class='left-sidebar']/h2")
    public WebElement leftSideBarCategoryH2;

    public WebElement getCategoryByVisibleName(String categoryName){
        for(WebElement w:accordionAlinks){
            if (w.isDisplayed() && w.getText().equalsIgnoreCase(categoryName)){
                return w;
            }
        }
        return accordionAlinks.get(0);
    }
}
