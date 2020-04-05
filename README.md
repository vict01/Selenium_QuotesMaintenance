# Quotes' Maintenance Automated Testing
## This is the test automation framework based on Selenium-webdriver, Junit and Maven to create tests easily for Quotes Maintenance.

In this framework we used diferent components resumed above, but below we will explain its functionality:

1. Selenium webdriver: Selenium is the framework used to automate the actions in the browser and locate elements, in this case, we use Chrome as browser and ChromeDriver as driver.
2. JUnit: Is the framework to create, organize and execute test.
3. Maven: Is the software applications that allows packaging and manage the dependencies.


## Requirements:
- Selenium-webdriver
- Junit
- Java 8
- Maven (latest version)
- Having installed chrome browser
## 

## Test Scope:
- In these tests, all requirements were  covered, no only points 3 and 4. Since in the QuotesIssueTesting class within RegressionTests module is described every findings. Convering like this, not only point 3, but also 1 and 2. 
- The GideonQuotesRecordingTest class within RegressionTests module, covers the point 4 of the requirements. 
## 

### How to use the test suite:
```
1. Go to RegressionTests module and run any of the java class contained in it accordingly to the "run test" option/button in any "@Test()" section if you're using IntelliJ IDE, or by right clic the class and choose "Run as Junit" with Eclipse.
2. Pay attention while test runs in the browser.
3. Once test finish to run, in the panel and dashboard of Jnunit in the IDE, you can see the testing summary report
```