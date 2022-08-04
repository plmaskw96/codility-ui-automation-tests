package com.gitlab.rmarzec.framework.pages.google.home_page;

import com.gitlab.rmarzec.framework.pages.google.home_page.windows.GoogleSearchResultsWindow;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;


public class GoogleHomePage extends WebPage {

    @FindBy(xpath = "//img[@alt='Google']/ancestor::div[@jscontroller]")
    private WebElement pageContainer;

    @FindBy(xpath = ".//input[@title='Search']")
    private WebElement searchTextField;

    @FindBy(xpath = ".//div[not(@jsname)]/center/input[@name='btnI']")
    private WebElement luckyPickButton;

    @FindBy(xpath = ".//li[@role='presentation']")
    private WebElement firstResult;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public GoogleHomePage isAt() {
        webWaitUtils.waitForClickable(luckyPickButton, Timeouts.MEDIUM);
        return this;
    }

    public GoogleSearchResultsWindow enterSearchText(String text) {
        enterText(searchTextField, text);
        webWaitUtils.waitForVisible(firstResult, Timeouts.MEDIUM);
        return new GoogleSearchResultsWindow(driver);
    }
}

