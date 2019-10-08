package steps;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import driver.DriverManager;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class HomePageStepDefs {

	private HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
	private SearchResultsPage searchResultsPage = new SearchResultsPage(DriverManager.getInstance().getDriver());
	private ProductPage productPage = new ProductPage(DriverManager.getInstance().getDriver());

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
			.clickMore();

		Map<String,String> dataSheet = productPage.readDataSheet();

		Assert.assertEquals(dataSheet.get("Compositions"),"Viscose");
		Assert.assertEquals(dataSheet.get("Styles"),"Dressy");
		Assert.assertEquals(dataSheet.get("Properties"),"Short Dress");
	}

	@Test
	public void checkAddingToCart() {
		homePage
			.openPage()
			.findCategory("Dresses")
			.hover()
			.findSubcategory("Evening Dresses")
			.click();

		searchResultsPage
			.findProduct("Printed Dress")
			.hover()
			.clickMore();

		productPage
			.selectSize("M")
			.selectColor("pink")
			.clickAddToCart();
			/*.clickContinueShopping();
			.checkCart();*/
	}

	@Test
	public void checkDeletingFromCart() {

	}

	@AfterClass
	public static void afterClass() {
		DriverManager.getInstance().closeDriver();
	}
	
	
}
