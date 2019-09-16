package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import config.Environment;
import driver.DriverManager;

@SuppressWarnings("ALL")
public class MainPage {

	Environment environment = new Environment();

	/* Elements */
	
	@FindBy(xpath = "//*[contains(@class,'sf-menu ')]")
	private WebElement mainMenu;
	
	/* Lists */
	
	
	
	/* Methods */
	
	public void openPage() {
		DriverManager.getInstance().getDriver().get(environment.getEnvironment());
	}
	
	
}
