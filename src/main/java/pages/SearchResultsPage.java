package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends AbstractPage {
	private static final String PRODUCT_ITEM_BY_TITLE = "//*[contains(@class, 'product-name')][contains(text(),'%s')]/ancestor::li";

	// private static final By PRODUCT_LIST_ITEMS = By.xpath("//*[contains(@class,'product_list')]/li");

	private static final By PRODUCT_MORE_BUTTON = By.xpath("//*[contains(@class,'product_list')]/li//span[contains(text(),'More')]/parent::*");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public Product findProduct(String productName) {
		// todo do it
	}

	public SearchResultsPage hoverOnProductByTitle(String productTitle) {
		By productLocator = By.xpath(String.format(PRODUCT_ITEM_BY_TITLE, productTitle));

		WebElement productElement = prepareElement(productLocator);

		getBuilder().moveToElement(productElement).perform();
		return this;
	}

	public SearchResultsPage clickOnProductMoreButton() {
		prepareElement(PRODUCT_MORE_BUTTON).click();
		return this;
	}
}
