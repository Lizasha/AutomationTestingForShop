package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.DriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	
	protected WebDriver driver;
	private static final int WAIT_FOR_ELEMENT_SECONDS = 10;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected Actions getBuilder() {
		Actions builder = new Actions(this.driver);
		return builder;
	}

	protected WebElement prepareElement(By locator) {
		// wait for load (to DOM)
		WebDriverWait wait = new WebDriverWait(this.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// get loaded element
		WebElement element = driver.findElement(locator);

		// check visibility
		boolean isVisible = element.isDisplayed();

		// navigate to element if it's not visible
		if (!isVisible) {
			getBuilder().moveToElement(element).perform();
		}

		// return this element
		return element;
	}

	public void waitElementLoaded(By locator) {}

	public void isElementVisible(By locator) {}

	public void scrollToElement(By locator) {}

	public void waitElementVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
}
