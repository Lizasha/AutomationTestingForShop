package steps;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import driver.DriverManager;
import pages.HomePage;
import pages.ItemPage;
import pages.SearchResultsPage;

public class HomePageStepDefs {

	private HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
	private SearchResultsPage searchResultsPage = new SearchResultsPage(DriverManager.getInstance().getDriver());
	private ItemPage itemPage = new ItemPage(DriverManager.getInstance().getDriver());

	@BeforeClass
	public static void beforeClass() {
		DriverManager.getInstance();
	}
	
	@Test
	public void checkDataSheet() {
		Map<String,String> datasheet = itemPage.readDataSheet();
		
		homePage.openPage();
		homePage.hoverOnDressesCategory();
		homePage.clickOnEveningDresses();
		searchResultsPage.hoverOnPrintedDress();
		searchResultsPage.clickOnMoreButton();
		Assert.assertEquals(datasheet.get("Compositions"),"Viscose");
		Assert.assertEquals(datasheet.get("Styles"),"Dressy");
		Assert.assertEquals(datasheet.get("Properties"),"Short Dress");
	}
	
	@AfterClass
	public static void afterClass() {
		DriverManager.getInstance().closeDriver();
	}
	
	
}
