package com.TestSuite;

import com.pageobjects.QuotesMaintenance;
import com.testFramework.core.BaseTest;
import org.junit.Before;
import org.junit.Test;


public class QuotesIssueTesting extends BaseTest {

    QuotesMaintenance quotesMaintenance;
    String author = "Carl";    String phrase = "ABC123";
    String author2 = "Vektor";    String phrase2 = "Do good without looking at who";

    @Before
    public void prepare() {
        quotesMaintenance = new QuotesMaintenance(getDriver());
    }

    @Test()
    /*Issues founded  through this test: (Prerequisite: none)
        1. The saving process is not indicated. There's no message about the process result.
        2. Phrases lower than length 10 are allowed.
        3. The requirement "The quote has to contain at least eight unique letters" is not met.  */
    public void addQuote() throws InterruptedException {
        quotesMaintenance.openQuotesMaintenance();
        quotesMaintenance.addNewQuote(author, phrase);
        quotesMaintenance.addNewQuote(author, phrase2);
        quotesMaintenance.searchQuote(phrase);
        quotesMaintenance.isThereMyQuote(phrase);
    }

    @Test()
    /*Issues founded  through this test: (Prerequisite: Run the above scenario first)
       1. New quotes containing 3 or more consecutive words are allowed, despite match with previous existing quotes.
       2. The alert "This quote violates rule 1." due to plagiarism, is not displayed.
       3. Page shows maximum 9 records, and there's no indication about it.    */
    public void editQuote() throws InterruptedException {
        quotesMaintenance.openQuotesMaintenance();
        quotesMaintenance.editQuote(author2, phrase2);
        quotesMaintenance.searchQuote("");
        quotesMaintenance.isThereMyQuote("looking");
    }

    /*Issues founded through this test: (Prerequisite: Run the above scenario first)
       1. Search by author does not recover any existing records.
       2. Search doesn't distinguish between lowercase and uppercase.   */
    @Test()
    public void searchQuote() throws InterruptedException {
        quotesMaintenance.openQuotesMaintenance();
        quotesMaintenance.searchQuote(author);
        quotesMaintenance.searchQuote("good");
        quotesMaintenance.isThereMyQuote("good");
        quotesMaintenance.searchQuote("GOOD");
        quotesMaintenance.isThereMyQuote("GOOD");
    }

}
