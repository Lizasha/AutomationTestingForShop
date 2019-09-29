package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Environment;
import driver.DriverManager;
import pages.elements.Category;

public class HomePage extends AbstractPage {
	private Environment environment = new Environment();

	private static final String CATEGORY_BY_NAME_LOCATOR = "//*[contains(@id, 'block_top_menu')]/ul/li/a[@title='%s']/parent::*";
	private static final String SUBCATEGORY_BY_NAME_LOCATOR = "//*[contains(@id, 'block_top_menu')]/ul/li//li/a[@title='%s']";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage openPage() {
		DriverManager.getInstance().getDriver().get(environment.getUrl());
		return this;
	}

	public Category findCategory(String categoryTitle) {
		By categoryLocator = By.xpath(String.format(CATEGORY_BY_NAME_LOCATOR, categoryTitle));
		return Category.prepareCategoryElement(categoryLocator);
	}
	
	public HomePage hoverOnCategoryByTitle(String categoryTitle) {
		By categoryLocator = By.xpath(String.format(CATEGORY_BY_NAME_LOCATOR, categoryTitle));
		WebElement categoryElement = prepareElement(categoryLocator);
		getBuilder().moveToElement(categoryElement).perform();
		return this;
	}
	
	public HomePage clickOnSubcategoryByTitle(String subcategoryTitle) {
		By subcategoryLocator = By.xpath(String.format(SUBCATEGORY_BY_NAME_LOCATOR, subcategoryTitle));
		WebElement subcategoryElement = prepareElement(subcategoryLocator);
		subcategoryElement.click();
		return this;
	}
	
	
}
