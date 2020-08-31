package core.driverManager;

import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

public abstract class DriverManager {

    public abstract Supplier<WebDriver> getDriver();
}
