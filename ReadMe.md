# Online Calculator
![Execution Status](https://img.shields.io/badge/executionStaus-success-brightgreen.svg?style=plastic)
> Automated test to verify working of Online Calculator with multiple dataset on calulation operations like Additon, Subtraction, and Division.

## Tool Stack
* Coding Language: Java (ver. 1.8)
* Build Tool: Maven
* Reporting: Cucumber Reports

**Libraries Used:**
- Selenium
- Cucumber
- Cucumber Junit
- Webdriver Manager

## Folder Structure
Entire code is placed under `src/test/` package.

`test/java` - contains all the source code required to execute automated checks.<br>
`test/resources` - contains `.feature` and `.properties` files

## Execution Point
Execution will being from `test/java/testRunner/Runner.java`. 
Execution Reports will be generated under `output` directory as `reports.html`

**Latest Execution Report Screenshot**
![Screenshot](output/ExecutionReportScreenshot.png)

_P.S.: Failed test case screenshot is not being displayed in the report due to some issues with the Cucumber report. If I change my method implementation to add a pass test case screenshot then only the first example screenshot is displayed in the report._ 