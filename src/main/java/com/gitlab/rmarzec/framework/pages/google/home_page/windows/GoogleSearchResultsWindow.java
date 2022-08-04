package com.gitlab.rmarzec.framework.pages.google.home_page.windows;

import com.gitlab.rmarzec.framework.pages.google.home_page.model.GoogleSearchResultModel;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import com.gitlab.rmarzec.framework.utils.locators_utils.LocatorListUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchResultsWindow extends WebPage {

    @FindBy(xpath = "//div[@jsname and @jscontroller and @style]")
    private WebElement pageContainer;

    @FindBy(xpath = ".//li[@role='presentation']")
    private List<WebElement> recordsList;

    @FindBy(xpath = ".//input[@name='btnI']")
    private List<WebElement> buttonsList;

    List<GoogleSearchResultModel> googleSearchResultModels;

    public GoogleSearchResultsWindow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public GoogleSearchResultsWindow isAt() {
        webWaitUtils.waitForClickable(recordsList.get(0), Timeouts.MEDIUM);
        googleSearchResultModels = recordsList.stream().map(webElement ->  new GoogleSearchResultModel(driver, webElement)).collect(Collectors.toList());
        return this;
    }

    public GoogleSearchResultsWindow clickImFellingLuckyButton() {
        clickElement(new LocatorListUtils(buttonsList).getElementFromListByValue("I'm Feeling Lucky"));
        return this;
    }
}
