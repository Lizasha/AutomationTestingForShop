package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import config.Environment;
import driver.DriverManager;

public class HomePage extends AbstractPage {

	private Environment environment = new Environment();

	/* Elements */
	
	private static final By DRESS_CATEGORY_LOCATOR = By.xpath("//*[contains(@class,'menu-content')]/li[2]");
	
	private static final By EVENING_DRESSES_SUBCATEGORY_LOCATOR = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a");
	
	/* Lists */
	
	/* Methods */
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage openPage() {
		DriverManager.getInstance().getDriver().get(environment.getEnvironment());
		return this;
	}
	
	public HomePage hoverOnDressesCategory() {
		getBuilder().moveToElement(driver.findElement(DRESS_CATEGORY_LOCATOR)).perform();
		return this;
	}
	
	public HomePage clickOnEveningDresses() {
		driver.findElement(EVENING_DRESSES_SUBCATEGORY_LOCATOR).click();
		return this;
	}
	
	
}
