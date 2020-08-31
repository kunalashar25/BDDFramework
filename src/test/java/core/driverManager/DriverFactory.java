package core.driverManager;

import core.driverManager.types.ChromeManager;
import core.driverManager.types.FirefoxManager;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<BrowserType, Supplier<WebDriver>> driverMap = new HashMap<>();
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // adding all supported browsers to the map
    static {
        driverMap.put(BrowserType.FIREFOX, new FirefoxManager().getDriver());
        driverMap.put(BrowserType.CHROME, new ChromeManager().getDriver());
    }

    /**
     * Get new WebDriver
     *
     * @param browserType browser instance name
     * @return driver
     */
    public static WebDriver getWebDriver(BrowserType browserType) {
        driverThreadLocal.set(driverMap.get(browserType).get());
        return driverThreadLocal.get();
    }

    public static WebDriver getCurrentDriver() {
        return driverThreadLocal.get();
    }

}
