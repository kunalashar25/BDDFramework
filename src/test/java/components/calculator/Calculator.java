package components.calculator;

import components.BaseComponent;
import constants.PageUrl;
import core.driverManager.DriverFactory;

public class Calculator extends BaseComponent implements ICalculator {

    public Calculator() {
        super(DriverFactory.getCurrentDriver());
    }

    /**
     * Load calculator page
     */
    @Override
    public void openPage() {
        loadPage(PageUrl.CALCULATOR);
    }
}
