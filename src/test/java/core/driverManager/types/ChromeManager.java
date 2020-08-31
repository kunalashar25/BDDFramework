package core.driverManager.types;

import core.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.function.Supplier;

public class ChromeManager extends DriverManager {

    /**
     * Creates new Instance of Chrome Driver
     *
     * @return driver
     */
    @Override
    public Supplier<WebDriver> getDriver() {
        return () -> {
            WebDriverManager.chromedriver().setup();
            return new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        };
    }

    /**
     * Set Chrome Instance Configuration
     *
     * @return chrome options
     */
    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        return chromeOptions;
    }
}
