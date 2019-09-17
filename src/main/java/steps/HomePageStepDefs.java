package steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import driver.DriverManager;
import pages.HomePage;

public class MainPageStepDefs {

	private HomePage homePage = new HomePage();

	@BeforeClass
	public static void beforeClass() {
		DriverManager.getInstance();
	}
	
	@Test
	public void checkDataSheet() {
		homePage.openPage();
		homePage.hoverOnElement();
		homePage.clickOnEveningDresses();
	}
	
	@AfterClass
	public static void afterClass() {
		DriverManager.getInstance().closeDriver();
	}
	
	
}
