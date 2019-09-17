package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import driver.DriverManager;

public class AbstractPage {
	
	protected WebDriver driver;
	private static final int WAIT_FOR_ELEMENT_SECONDS = 10;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected Actions getBuilder() {
		Actions builder = new Actions(DriverManager.getInstance().getDriver());
		return builder;
	}
	
	
}
