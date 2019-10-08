package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPreview extends AbstractElement<ProductPreview> {

	private static final By MORE_BUTTON = By.xpath("//span[text()='More']/parent::a");

	public ProductPreview(WebElement element) {
		super(element);
	}

	public ProductPreview clickMore() {
		prepareElement(MORE_BUTTON);
		getElement().findElement(MORE_BUTTON).click();
		return this;
	}
}
