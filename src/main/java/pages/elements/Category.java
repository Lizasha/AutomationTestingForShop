package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Category extends AbstractElement<Category> {
    private static final String SUBCATEGORY_BY_NAME_LOCATOR = ".//li/a[@title='%s']";

    public Category(WebElement element) {
        super(element);
    }

    public static Category prepareCategoryElement(By elementLocator) {
        return new Category(AbstractElement.prepareElement(elementLocator));
    }

    public SubCategory findSubcategory(String subcategoryTitle) {
        By subcategoryLocator = By.xpath(String.format(SUBCATEGORY_BY_NAME_LOCATOR, subcategoryTitle));
        WebElement subcategoryElement = getElement().findElement(subcategoryLocator);
        return new SubCategory(subcategoryElement);
    }

    @Override
    public Category hover() {
        WebElement linkElement = getElement().findElement(By.xpath("./a"));
        createAction()
                .moveToElement(linkElement)
                .perform();
        return this;
    }
}
