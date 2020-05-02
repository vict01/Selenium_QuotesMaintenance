package com.pageobjects;

import com.testFramework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class QuotesSourcePage extends BasePage {

    String url = "https://agoldoffish.wordpress.com/criminal-minds-opening-and-closing-quotes/";
    String author = "";
    String phrase = "";

    @FindBy(how = How.XPATH, using = "//p[contains(strong, 'Gideon')]")
    public List<WebElement> gideonQuotesList;

    public QuotesSourcePage(WebDriver driver) {
        super(driver);
    }

    public void openQuotesListPage() {
        myDriver.get(url);
    }

    public String getAuthorList(int i){
        author = gideonQuotesList.get(i).getText();
        int index = author.indexOf(":");
        boolean isThereLimit = index > 0;
        author = author.substring(0, isThereLimit ? index : author.length()-1);
        return author;
    }

    public String getPhraseList(int i){
        phrase = gideonQuotesList.get(i).getText().replace(getAuthorList(i), "");
        return phrase;
    }

}