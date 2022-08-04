package com.gitlab.rmarzec.framework.pages.wikipedia.hoempage;

import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class WikipediaHomePage extends WebPage {

    @FindBy(xpath = "//div[@role='main']")
    private WebElement pageContainer;

    @FindBy(xpath = ".//div[@id='catlinks']")
    private WebElement catlinks;

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public WikipediaHomePage isAt() {
        webWaitUtils.waitForVisible(catlinks, Timeouts.MEDIUM);
        return this;
    }
}
