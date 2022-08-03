package com.gitlab.rmarzec.framework.pages.google.windows;

import com.gitlab.rmarzec.framework.pages.google.GoogleMainPage;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import com.gitlab.rmarzec.framework.utils.locators_utils.LocatorListUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class GoogleCookieWindow extends WebPage {

    @FindBy(xpath = "//img[@alt='Google']/parent::div[@class and @id]/../..")
    private WebElement pageContainer;

    @FindBy(xpath = ".//button[@tabindex]")
    private WebElement moreOptionsButton;

    @FindBy(xpath = ".//div[@class and @role='none']")
    private List<WebElement> buttonsList;

    public GoogleCookieWindow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public GoogleCookieWindow isAt() {
        webWaitUtils.waitForClickable(moreOptionsButton, Timeouts.LOW);
        return this;
    }

    public GoogleMainPage clickAgreeButton() {
        clickElement(new LocatorListUtils(buttonsList).getElementFromListByName("Accept all"));
        webWaitUtils.waitForNotVisible(moreOptionsButton, Timeouts.LOW);
        return new GoogleMainPage(driver).isAt();
    }
}
