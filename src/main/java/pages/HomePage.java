package pages;


import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import config.Environment;
import driver.DriverManager;

@SuppressWarnings("ALL")
public class MainPage {

	Environment environment = new Environment();

	/* Elements */
	
	@FindBy(xpath = "")
	private WebElement dressesCategory;
	
	@FindBy(xpath = "//*[contains(@class,'menu-content')]/li")
	private ArrayList<WebElement> menuContent;
	
	/* Lists */
	
	/* Methods */
	
	public void openPage() {
		DriverManager.getInstance().getDriver().get(environment.getEnvironment());
	}
	
	public void hoverOnElement() {
		Actions builder = new Actions(DriverManager.getInstance().getDriver());
		builder.moveToElement(menuContent.get(0)).perform();
	}
	
	
}
