package stepDefinition;

import components.Calculator;
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
        System.out.println("URL:: "+calculator.getCalculatorPageUrl());
    }

    @When("user enters calculation values {int} {string} {int}")
    public void user_enters_calculation_values(Integer value1, String operator, Integer value2) {
        System.out.println("Value1:: " + value1 + " | Operator:: " + operator + " | Value2::" + value2);
    }

    @Then("calculation result should be displayed as {int}")
    public void calculation_result_should_be_displayed_as(Integer expectedResult) {
        System.out.println("Result:: " + expectedResult);
    }
}
