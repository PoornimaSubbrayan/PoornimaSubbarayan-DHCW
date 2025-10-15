# PoornimaSubbarayan-DHCW Test Automation Framework

## Overview
This project is a web test automation framework built with Java, Maven, Cucumber (BDD), JUnit, and Allure for reporting. It is designed for scalable, maintainable, and efficient automated testing of web applications.

---

## Tech Stack
- Java
- Selenium
- Maven
- Cucumber (BDD)
- JUnit
- Allure Reporting

---

## Folder Structure
```
src/test/resources/features - this folder contains the feature files.
src/test/java/stepdefinitions - this folder contains the step definition classes.
src/test/java/pages - this folder contains the page object classes.
src/test/java/hooks - this folder contains the hooks for setup and teardown.
src/test/java/utility - this folder contains utility classes like WebDriver management and property reading.
src/test/resources/properties - this folder contains properties files for locators and test data.
target/allure-results/ - this folder contains the results for Allure reports.
target/allure-report/ - this folder contains the generated Allure report.

```

---

## How to Execute Tests
1. Open a terminal/command prompt in the project root directory.
2. Run the following command:
   ```
   mvn clean verify
   ```
   This will execute all tests as configured in `RunCucumberTest.java`.

---

## Test Reports
- **Allure Report**: After test execution, the reports will be saved in target/allure-report folder.
- To view the Allure report:
1. Open the file: `target/allure-report/index.html` in a web browser.

---

## Customization
- To run specific scenarios, set the `tags` value in `RunCucumberTest.java` (e.g., `tags = "@login"`).

---

## Requirements
- Java 24
- Maven 3.9.9 or higher

---

*Last updated: October 15, 2025*

