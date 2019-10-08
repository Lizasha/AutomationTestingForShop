package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.elements.ProductPreview;

public class SearchResultsPage extends AbstractPage {
	private static final String PRODUCT_ITEM_BY_TITLE = "//*[contains(@class, 'product-name')][contains(text(),'%s')]/ancestor::li";

	// private static final By PRODUCT_LIST_ITEMS = By.xpath("//*[contains(@class,'product_list')]/li");

	private static final By PRODUCT_MORE_BUTTON = By.xpath("//*[contains(@class,'product_list')]/li//span[contains(text(),'More')]/parent::*");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public ProductPreview findProduct(String productName) {
		By productLocator = By.xpath(String.format(PRODUCT_ITEM_BY_TITLE, productName));
		WebElement productElement = prepareElement(productLocator);
		return new ProductPreview(productElement);
	}

	public SearchResultsPage clickOnProductMoreButton() {
		prepareElement(PRODUCT_MORE_BUTTON).click();
		return this;
	}
}
