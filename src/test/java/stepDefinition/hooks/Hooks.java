package stepDefinition.hooks;

import core.driverManager.BrowserType;
import core.driverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.internal.com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private WebDriver driver;

    /**
     * To initiate new driver for current scenario execution
     */
    @Before(order = 1)
    public void setUp() {
        this.driver = DriverFactory.getWebDriver(BrowserType.CHROME);
        this.driver.manage().window().maximize();
    }

    /**
     * To close browser after all processes are completed
     */
    @After(order = 1)
    public void tearDown() {
        // adding sleep to view result on UI before it is closed. No need to write this line in actual project
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.driver.quit();
    }

    /**
     * Capturing screenshot on scenario failure
     *
     * @param scenario current scenario
     */
    @After
    public void captureScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "ExecutionFailed");
        }
    }
}
