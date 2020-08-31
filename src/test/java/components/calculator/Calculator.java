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

    /**
     * Perform calculation for given input
     *
     * @param value1
     * @param operation
     * @param value2
     */
    @Override
    public void performCalculation(double value1, String operation, double value2) {
        switchToFrame(IFRAME_CALCULATOR);
        enterTextUsingActions(value1 + "");
        enterTextUsingActions(operation);
        enterTextUsingActions(value2 + "");
    }

    /**
     * Get calculation result from UI
     *
     * @return result
     */
    @Override
    public String getResult() {
        enterTextUsingActions("=");
        return getTextUsingJS();
    }

}
