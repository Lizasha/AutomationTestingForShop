package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.SearchResultsPage;

public class Product extends AbstractElement<Product> {

	private static final By MORE_BUTTON = By.xpath("//span[text()='More']/parent::a");

	public Product(WebElement element) {
		super(element);
	}

	public Product clickMore() {
		getElement().findElement(MORE_BUTTON).click();
		return this;
	}
}
