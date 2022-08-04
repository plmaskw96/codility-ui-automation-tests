package com.gitlab.rmarzec.framework.pages.google.homepage.model;

import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class GoogleSearchResultModel extends WebPage {

    @FindBy(xpath = ".//span")
    private WebElement textValue;

    public GoogleSearchResultModel(WebDriver driver, WebElement wrapper) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(wrapper), this);
    }

    public String getTextValue() {
        return textValue.getText();
    }
}
