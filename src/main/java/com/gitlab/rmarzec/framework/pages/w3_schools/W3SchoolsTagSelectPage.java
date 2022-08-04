package com.gitlab.rmarzec.framework.pages.w3_schools;

import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class W3SchoolsTagSelectPage extends WebPage {

    @FindBy(xpath = "//div[@class='w3-row w3-white']")
    private WebElement pageContainer;

    @FindBy(xpath = ".//div[contains(@id, 'in-main_leaderboard')]")
    private WebElement mainAdvertisement;

    public W3SchoolsTagSelectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public W3SchoolsTagSelectPage isAt() {
        webWaitUtils.waitForVisible(mainAdvertisement, Timeouts.MEDIUM);
        return this;
    }
}
