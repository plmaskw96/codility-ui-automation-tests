package com.gitlab.rmarzec.framework.pages.google;

import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class GoogleMainPage extends WebPage {

    @FindBy(xpath = "//img[@alt='Google']/ancestor::div[@jscontroller]")
    private WebElement pageContainer;

    @FindBy(xpath = ".//div[not(@jsname)]/center/input[@name='btnI']")
    private WebElement luckyPickButton;

    public GoogleMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public GoogleMainPage isAt() {
        webWaitUtils.waitForVisible(luckyPickButton, Timeouts.MEDIUM);
        return this;
    }
}

