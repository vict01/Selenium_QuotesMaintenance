package com.TestSuite;

import com.pageobjects.QuotesSourcePage;
import com.pageobjects.QuotesMaintenance;
import com.testFramework.core.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GideonQuotesRecordingTest extends BaseTest {

    QuotesSourcePage quotesSourcePage;
    QuotesMaintenance quotesMaintenance;
    List<String> strAuthorList = new ArrayList<>();
    List<String> strPhraseList = new ArrayList<>();
    String author = "";
    String phrase = "";

    @Before
    public void prepare() {
        quotesSourcePage = new QuotesSourcePage(getDriver());
        quotesMaintenance = new QuotesMaintenance(getDriver());
    }

    @Test()
    public void gideonQuotesRecording() throws InterruptedException {
        quotesSourcePage.openQuotesListPage();
        int gideonListSize = quotesSourcePage.gideonQuotesList.size();

        for (int i = 0; i < gideonListSize; i++) {
            strAuthorList.add(quotesSourcePage.getAuthorList(i));
            strPhraseList.add(quotesSourcePage.getPhraseList(i));
        }

        quotesMaintenance.openQuotesMaintenance();
        for (int i = 0; i < strAuthorList.size(); i++) {
            author = strAuthorList.get(i);
            phrase = strPhraseList.get(i);
            quotesMaintenance.addNewQuote(author, phrase);
        }
        quotesMaintenance.searchQuote(author);
        assert strAuthorList.size() >= quotesMaintenance.howManyQuotesByAuthor();
    }

}
