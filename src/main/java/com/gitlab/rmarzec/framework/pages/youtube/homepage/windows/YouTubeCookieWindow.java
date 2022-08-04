package com.gitlab.rmarzec.framework.pages.youtube.homepage.windows;

import com.gitlab.rmarzec.framework.pages.youtube.homepage.YoutubeHomePage;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import com.gitlab.rmarzec.framework.utils.locators_utils.LocatorListUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class YouTubeCookieWindow extends WebPage {

    @FindBy(xpath = "//tp-yt-paper-dialog[@id='dialog']")
    private WebElement pageContainer;

    @FindBy(xpath = "//ytd-guide-signin-promo-renderer/yt-formatted-string")
    private WebElement leftLogInField;

    @FindBy(xpath = ".//div[contains(@class, 'termlinks')]")
    private WebElement termsLinks;

    @FindBy(xpath = ".//tp-yt-paper-button")
    private List<WebElement> buttonsList;

    public YouTubeCookieWindow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public YouTubeCookieWindow isAt() {
        webWaitUtils.waitForClickable(termsLinks, Timeouts.MEDIUM);
        return this;
    }

    public YoutubeHomePage clickAgreeButton() {
        clickElement(new LocatorListUtils(buttonsList).getElementFromListByAttributeContains("aria-label","Accept the use of cookies"));
        webWaitUtils.waitForNotVisible(leftLogInField, Timeouts.VERY_LOW);
        return new YoutubeHomePage(driver).isAt();
    }
}
