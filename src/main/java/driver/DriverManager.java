package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
private static DriverManager instance;
	private static WebDriver driver;

	private DriverManager() {
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static DriverManager getInstance() {
		if (instance == null) {
			instance = new DriverManager();
			initializationDriver();
		}
		return instance;
	}

	private static void initializationDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void closeDriver() {
		driver.quit();
	}

}
