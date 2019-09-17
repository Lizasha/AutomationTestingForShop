package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import driver.DriverManager;

public class SearchResultsPage extends AbstractPage {
	private static final By PRINTED_DRESS_SUBCATEGORY = By.xpath("//*[contains(@class,'product_list')]/li[1]");
	
	private static final By MORE_BUTTON = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public SearchResultsPage hoverOnPrintedDress() {
		getBuilder().moveToElement(driver.findElement(PRINTED_DRESS_SUBCATEGORY)).perform();
		return this;
	}
	
	public SearchResultsPage clickOnMoreButton() {
		driver.findElement(MORE_BUTTON).click();
		return this;
	}
}
