package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.elements.SizePicker;

public class ProductPage extends AbstractPage {

	private static final By SHEET_TABLE = By.xpath("//*[contains(@class,'table-data-sheet')]");

	private static final By SHEET_ENTRIES = By.xpath("./tbody//tr");

	
	public ProductPage(WebDriver driver) {
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

	public ProductPage selectSize(String size) {
		WebElement sizeField = prepareElement(SizePicker.SIZE_FIELD); // it is public, static -> don't need create entity; it possible to use it in other class
		SizePicker sizePicker = new SizePicker(sizeField);
		sizePicker.selectDropDown(size);
		return this;
	}


	public ProductPage selectColor(String color) {
		return this;
	}

	public ProductPage clickAddToCart() {

		return this;
	}
}
