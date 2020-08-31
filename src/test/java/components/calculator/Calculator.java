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

    @Override
    public void performCalculation(double value1, String operation, double value2) {
        switchToFrame(IFRAME_CALCULATOR);
        enterTextUsingActions(CANVAS_CALCULATOR, value1 + "");
        enterTextUsingActions(CANVAS_CALCULATOR, operation);
        enterTextUsingActions(CANVAS_CALCULATOR, value2 + "");
    }

    @Override
    public String getResult() {
        enterTextUsingActions(CANVAS_CALCULATOR, "=");

        return null;
    }

}
