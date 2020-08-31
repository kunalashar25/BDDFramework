package components.calculator;

import org.openqa.selenium.By;

public interface ICalculator {

    By IFRAME_CALCULATOR = By.id("fullframe");
    By CANVAS_CALCULATOR = By.id("canvas");

    public void openPage();
}
