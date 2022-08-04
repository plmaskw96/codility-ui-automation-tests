package com.gitlab.rmarzec.framework.pages.w3_schools.tags.model;

import com.gitlab.rmarzec.framework.pages.w3_schools.tags.component.Example;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ExampleModel extends WebPage {

    @FindBy(xpath = ".//p")
    private WebElement description;

    @FindBy(xpath = ".//div[@class='w3-code notranslate htmlHigh']")
    private WebElement bodyLocator;

    @FindBy(xpath = ".//a")
    private WebElement tryItYourselfButton;

    public ExampleModel(WebDriver driver, WebElement wrapper) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(wrapper), this);
    }

    public Example toModel() {
        return Example.builder()
                .description(description.getText())
                .bodyLocator(bodyLocator)
                .tryItYourselfButton(tryItYourselfButton)
                .build();
    }
}
