package components;

import io.cucumber.messages.internal.com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

    /**
     * Wait until element is visible
     *
     * @param by
     */
    private void waitForVisibilityOfElement(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    /**
     * Load web page
     *
     * @param pageUrl
     */
    protected void loadPage(String pageUrl) {
        driver.get(pageUrl);
        waitForPageLoad();
    }

    /**
     * Wait for page to be loaded completely
     */
    protected void waitForPageLoad() {
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

    /**
     * Switch to frame
     *
     * @param by
     */
    protected void switchToFrame(By by) {
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    /**
     * Enter text on UI using Actions class
     *
     * @param value
     */
    protected void enterTextUsingActions(String value) {
        new Actions(driver).sendKeys(value).build().perform();
    }

    /**
     * Get Text from UI using Javascript Executor
     *
     * @return String
     */
    protected String getTextUsingJS() {
        Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return exportRoot.showscreen_txt.text;", "");
    }

}
