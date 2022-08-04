package com.gitlab.rmarzec.framework.pages.youtube.homepage.section;

import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class YouTubeTrendingSection extends WebPage {

    @FindBy(xpath = "//span[@id='title'][.='Trending']/ancestor::div[@id='dismissible']")
    private WebElement pageContainer;

    @FindBy(xpath = ".//ytd-button-renderer[@id='show-more-button']")
    private WebElement expandButton;

    public YouTubeTrendingSection(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public YouTubeTrendingSection expandTrendingSection() {
        scrollToElement(pageContainer);
        clickElement(expandButton);
        webWaitUtils.waitForNotVisible(expandButton, Timeouts.LOW);
        return new YouTubeTrendingSection(driver);
    }
}
