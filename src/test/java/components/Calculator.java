package components;

import core.driverManager.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Calculator extends BaseComponent {

    public Calculator() {
        super(DriverFactory.getCurrentDriver());
    }

    public String getCalculatorPageUrl() {
        return getPageUrl();
    }


}
