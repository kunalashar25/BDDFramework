package stepDefinition;

import components.calculator.Calculator;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSteps {

    Calculator calculator;

    @Before
    public void initializeComponents() {
        this.calculator = new Calculator();
    }

    @Given("Navigate to calculator page")
    public void navigate_to_calculator_page() {
        calculator.openPage();
    }

    @When("user enters calculation values {double} {string} {double}")
    public void user_enters_calculation_values(Double value1, String operator, Double value2) {
        calculator.performCalculation(value1, operator, value2);
    }

    @Then("calculation result should be displayed as {int}")
    public void calculation_result_should_be_displayed_as(Integer expectedResult) {
        calculator.getResult();
    }
}
