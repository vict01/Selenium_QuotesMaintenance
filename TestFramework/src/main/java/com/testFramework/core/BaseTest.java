package com.testFramework.core;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static WebDriver driver;

    @BeforeClass
    public static void beforeSuite() {
        try {
            String driverPath = "..\\TestFramework\\src\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert driver != null;
    }

    @AfterClass
    public static void afterSuite() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
