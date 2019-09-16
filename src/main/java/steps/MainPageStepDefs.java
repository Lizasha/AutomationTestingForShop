package steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import driver.DriverManager;
import pages.MainPage;

public class MainPageStepDefs {

	private MainPage mainPage = new MainPage();

	@BeforeClass
	public static void beforeClass() {
		DriverManager.getInstance();
	}
	
	@Test
	public void checkDataSheet() {
		mainPage.openPage();
	}
	
	@AfterClass
	public static void afterClass() {
		DriverManager.getInstance().closeDriver();
	}
	
	
}
