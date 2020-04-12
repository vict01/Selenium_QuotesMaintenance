package com.testFramework.core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private static final int TIMEOUT = 7;
    private static final int POLLING = 100;

    protected WebDriver myDriver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.myDriver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    protected void waitForElementToBeLoaded(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementToBePresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForLabelToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        //      wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)));
    }

    protected void waitForLabelToFadesOut(WebElement element) {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }

    protected void waitForListToBePresent(List<WebElement> element) {
        wait.until(ExpectedConditions.visibilityOf((WebElement) element));
    }

}
