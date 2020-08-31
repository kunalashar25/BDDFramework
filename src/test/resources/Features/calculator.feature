Feature: Test working of online calculator

  Scenario Outline: To test Addition, Subtraction, and Division of values
    Given Navigate to calculator page
    When user enters calculation values <value1> <operator> <value2>
    Then calculation result should be displayed as <result>

    Examples:
      | value1 | operator | value2 | result  |
      | 1      | "+"      | 2      | "3"     |
      | 1.1    | "-"      | 2.2    | "-1.1"  |
      | 3      | "/"      | 2      | "1.5"   |
      | 3      | "/"      | 0      | "Error" |
      | 5.82   | "+"      | 1.18   | "8"     |