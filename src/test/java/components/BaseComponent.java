package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base component acts as a wrapper layer between our framework and selenium library.
 */
public abstract class BaseComponent {

    WebDriver driver;
    WebDriverWait webDriverWait;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 20);
    }

    public void waitForVisibilityOfElement(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void click(By by) {
        waitForVisibilityOfElement(by);
        driver.findElement(by).click();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
