package pages.elements;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class AbstractElement<T extends AbstractElement<?>> {
    private WebElement element;
    private WebDriver driver;

    public AbstractElement(WebElement element) {
        setElement(element);
        driver = DriverManager.getInstance().getDriver();
    }

    static WebElement prepareElement(By elementLocator) {
        WebDriver driver = DriverManager.getInstance().getDriver();

        // wait for load (to DOM)
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));

        // get loaded element
        WebElement element = driver.findElement(elementLocator);

        // check visibility
        boolean isVisible = element.isDisplayed();

        // navigate to element if it's not visible
        if (!isVisible) {
            createAction().moveToElement(element).perform();
        }

        return element;
    }

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    static Actions createAction() {
        return new Actions(DriverManager.getInstance().getDriver());
    }

    public T click() {
        getElement().click();
        return (T) this;
    }

    public T hover() {
        createAction()
                .moveToElement(getElement())
                .perform();
        return (T) this;
    }
}
