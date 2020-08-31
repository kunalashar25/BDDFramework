package components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base component acts as a wrapper layer between our framework and selenium library.
 */
public abstract class BaseComponent {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 20);
    }

    private void waitForVisibilityOfElement(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void loadPage(String pageUrl) {
        driver.get(pageUrl);
        waitForPageLoad();
    }

    protected void waitForPageLoad() {
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

    protected String getPageUrl() {
        return driver.getCurrentUrl();
    }

    protected void click(By by) {
        waitForVisibilityOfElement(by);
        driver.findElement(by).click();
    }

    protected void switchToFrame(By by) {
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    protected void enterTextUsingActions(By by, String value) {
        new Actions(driver).sendKeys(value).build().perform();
    }

    protected String getTextUsingJS(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return exportRoot.showscreen_txt.text;", "");
    }


}
