package core.driverManager.types;

import core.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.function.Supplier;

public class FirefoxManager extends DriverManager {

    /**
     * Creates new Instance of Firefox Driver
     *
     * @return driver
     */
    @Override
    public Supplier<WebDriver> getDriver() {
        return () -> {
            WebDriverManager.firefoxdriver().setup();
            return new EventFiringWebDriver(new FirefoxDriver(getFirefoxOptions()));
        };
    }

    /**
     * Set Firefox Instance Configuration
     *
     * @return firefox options
     */
    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("disable-infobars");
        return firefoxOptions;
    }
}
