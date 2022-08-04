package com.gitlab.rmarzec.framework.pages.w3_schools.windows;

import com.gitlab.rmarzec.framework.pages.w3_schools.W3SchoolsTagSelectPage;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import com.gitlab.rmarzec.framework.utils.locators_utils.LocatorListUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class W3SchoolsCookieWindow extends WebPage {

    @FindBy(xpath = "//div[contains(@class, 'sn-privacy')]/ancestor::div[@id='snigel-cmp-framework']")
    private WebElement pageContainer;

    @FindBy(xpath = ".//div[contains(@class,'sn-b-def')]")
    private List<WebElement> buttonsList;

    public W3SchoolsCookieWindow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public W3SchoolsCookieWindow isAt() {
        webWaitUtils.waitForClickable(buttonsList.get(0), Timeouts.MEDIUM);
        return this;
    }

    public W3SchoolsTagSelectPage clickAgreeButton() {
        clickElement(new LocatorListUtils(buttonsList).getElementFromListByName("Accept all & visit the site"));
        webWaitUtils.waitForNotVisible(pageContainer, Timeouts.LOW);
        return new W3SchoolsTagSelectPage(driver).isAt();
    }
}
