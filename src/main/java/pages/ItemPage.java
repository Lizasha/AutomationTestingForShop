package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverManager;

public class ItemPage extends AbstractPage {

	private static final By SHEET_TABLE = By.xpath("//*[contains(@class,'table-data-sheet')]");
	private static final By SHEET_ENTRIES = By.xpath("./tbody//tr");
	
	public ItemPage(WebDriver driver) {
		super(driver);
	}
	
	public Map<String,String> readDataSheet() {
		HashMap<String, String> dataSheet = new HashMap<>();
		WebElement table = prepareElement(SHEET_TABLE);
		List<WebElement> entries = table.findElements(SHEET_ENTRIES);

		entries.forEach((row) -> {
			List<WebElement> childs = row.findElements(By.xpath(".//*"));
			dataSheet.put(childs.get(0).getText(), childs.get(1).getText());
		});

		return dataSheet;
	}
}
