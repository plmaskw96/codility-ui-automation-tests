package com.gitlab.rmarzec.framework.pages.wikipedia.left_panel;

import com.gitlab.rmarzec.framework.pages.wikipedia.left_panel.sections.WikipediaLanguagesSection;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class WikipediaLeftPanelPage extends WebPage {

    @FindBy(xpath = "//div[@id='mw-panel']")
    private WebElement pageContainer;

    @FindBy(xpath = ".//li[@class='mw-list-item mw-list-item-js']")
    private WebElement proposeToSocialMediaOption;

    public WikipediaLeftPanelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public WikipediaLeftPanelPage isAt() {
        webWaitUtils.waitForVisible(proposeToSocialMediaOption, Timeouts.MEDIUM);
        return this;
    }

    public WikipediaLanguagesSection getLanguagesSection() {
        return new WikipediaLanguagesSection(driver);
    }
}
