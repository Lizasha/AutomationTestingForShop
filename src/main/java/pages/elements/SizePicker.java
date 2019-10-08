package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SizePicker extends AbstractElement<SizePicker> {

    public static final By SIZE_FIELD = By.xpath("//div[@id='attributes']//label[contains(text(),'Size')]/..");

    private static final By SIZE_DROPDOWN = By.xpath("//select[@name]");

    private static final String SIZE = "/option[@title='%s']";

    public SizePicker(WebElement element) {
        super(element);
    }

    public SizePicker selectDropDown(String size) {
        By chosenSizeLocator = (By.xpath(String.format(SIZE, size)));
        WebElement chosenSizeElement = getElement().findElement(chosenSizeLocator);
        return new SizePicker(chosenSizeElement);


    }
}
