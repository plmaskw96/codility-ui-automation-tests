package com.gitlab.rmarzec.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebPage {

    protected WebDriver driver;
    protected WebWaitUtils webWaitUtils;

    public WebPage(WebDriver driver) {
        this.driver = driver;
        this.webWaitUtils = new WebWaitUtils(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.click();
        element.sendKeys(text);
    }
}
