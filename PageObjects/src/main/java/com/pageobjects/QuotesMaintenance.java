package com.pageobjects;

import com.testFramework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class QuotesMaintenance extends BasePage {

    String url = "https://www-5e843a9176ebdb7f82181e05.recruit.eb7.io/";
    String quote = "";
    public static final String spinLoading = "//i[@class='fa fa-refresh fa-spin']";

    @FindBy(how = How.ID, using = "searchBar")
    public WebElement searchQuoteTxt;

    @FindBy(how = How.XPATH, using = spinLoading)
    public WebElement spinLoadingQuoteLbl;

    @FindBy(how = How.XPATH, using = "//div[@class='panel-heading']")
    public WebElement existingQuoteLbl;

    @FindBy(how = How.XPATH, using = "//li[@class='quotes__header']")
    public WebElement qtyQuoteByAuthorHeaderLbl;

    @FindBy(how = How.XPATH, using = "//p[@class='sidenav__tab__info']")
    public WebElement qtyQuoteByAuthorBoxLbl;

    @FindBy(how = How.XPATH, using = "//div[@class='panel-body']/p[contains(text(),'No quotes found.')]")
    public WebElement noFoundQuoteLbl;

    @FindBy(how = How.XPATH, using = "//p[@class='quotes__title']")
    public WebElement recoveredQuoteLbl;

    @FindBy(how = How.ID, using = "show-modal")
    public WebElement addQuoteBtn;

    @FindBy(how = How.XPATH, using = "//li[@class='quotes']")
    public WebElement recoveredQuoteBox;

    @FindBy(how = How.XPATH, using = "//input[@name='author']")
    public WebElement editAuthorTxt;

    @FindBy(how = How.XPATH, using = "//input[@name='text']")
    public WebElement editQuoteTxt;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement saveEditBtn;

    // Pop-up Elements to add new quote:
    @FindBy(how = How.ID, using = "autorInput")
    public WebElement addAuthorTxt;

    @FindBy(how = How.ID, using = "quoteInput")
    public WebElement addQuoteTxt;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-success modal-default-button']")
    public WebElement saveAddBtn;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-default modal-default-button']")
    public WebElement cancelAddBtn;


    public QuotesMaintenance(WebDriver driver) {
        super(driver);
    }

    public void openQuotesMaintenance() {
        myDriver.get(url);
    }

    public void searchQuote(String phrase) throws InterruptedException {
        try {
            waitForElementToBeLoaded(searchQuoteTxt);
            searchQuoteTxt.sendKeys(phrase);
            searchQuoteTxt.submit();
            waitForElementToDisappear(By.xpath(spinLoading));
        } catch (IllegalMonitorStateException e) {
            e.wait(10000);
        }
    }

    public void addNewQuote (String author, String phrase){
        waitForElementToBeLoaded(addQuoteBtn);
        addQuoteBtn.click();
        addAuthorTxt.sendKeys(author);
        addQuoteTxt.sendKeys(phrase);
        saveAddBtn.click();
    }

    public void editQuote (String author, String phrase){
        waitForElementToBeLoaded(recoveredQuoteBox);
        recoveredQuoteBox.click();
        waitForElementToBeSelected(editAuthorTxt);
        editAuthorTxt.sendKeys(author);
        editQuoteTxt.sendKeys(phrase);
        saveEditBtn.click();
    }

    public void isThereMyQuote(String element) {
        waitForElementToBePresent(recoveredQuoteLbl);
        assert recoveredQuoteLbl.toString().contains(element);
    }

    public int howManyQuotesByAuthor() {
        waitForElementToBePresent(qtyQuoteByAuthorHeaderLbl);
        int qtyQuoteByAuthor;
        qtyQuoteByAuthor = Integer.parseInt(qtyQuoteByAuthorHeaderLbl.getText());
        return qtyQuoteByAuthor;
    }

}