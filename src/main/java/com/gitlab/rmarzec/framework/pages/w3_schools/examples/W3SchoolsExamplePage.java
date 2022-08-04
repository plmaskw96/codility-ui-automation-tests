package com.gitlab.rmarzec.framework.pages.w3_schools.examples;

import com.gitlab.rmarzec.framework.pages.w3_schools.examples.sections.W3SchoolsExampleResultsSection;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;


public class W3SchoolsExamplePage extends WebPage {

    @FindBy(xpath = "//iframe[@id='iframeResult']/ancestor::body")
    private WebElement pageContainer;

    @FindBy(xpath = ".//div[contains(@id, 'google_ads_iframe_')]")
    private WebElement mainAdvertisement;

    public W3SchoolsExamplePage(WebDriver driver) {
        super(driver);
        switchToNextWindow();
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public W3SchoolsExamplePage isAt() {
        webWaitUtils.waitForVisible(mainAdvertisement, Timeouts.LOW);
        return this;
    }

    public W3SchoolsExampleResultsSection getResultsSection() {
        return new W3SchoolsExampleResultsSection(driver);
    }
}
