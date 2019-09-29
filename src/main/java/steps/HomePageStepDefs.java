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
		homePage
			.openPage()
			.findCategory("Dresses")
			.hover()
			.findSubcategory("Evening Dresses")
			.click();

		searchResultsPage
			.findProduct("Printed Dress")
			.hover()
			.clickMoreButton();

		Map<String,String> dataSheet = itemPage.readDataSheet();

		Assert.assertEquals(dataSheet.get("Compositions"),"Viscose");
		Assert.assertEquals(dataSheet.get("Styles"),"Dressy");
		Assert.assertEquals(dataSheet.get("Properties"),"Short Dress");
	}

	@AfterClass
	public static void afterClass() {
		DriverManager.getInstance().closeDriver();
	}
	
	
}
