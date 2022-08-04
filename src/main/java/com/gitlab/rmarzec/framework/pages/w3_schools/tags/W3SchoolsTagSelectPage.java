package com.gitlab.rmarzec.framework.pages.w3_schools.tags;

import com.gitlab.rmarzec.framework.pages.w3_schools.examples.W3SchoolsExamplePage;
import com.gitlab.rmarzec.framework.pages.w3_schools.tags.model.ExampleModel;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class W3SchoolsTagSelectPage extends WebPage {

    @FindBy(xpath = "//div[@class='w3-row w3-white']")
    private WebElement pageContainer;

    @FindBy(xpath = ".//div[contains(@id, 'in-main_leaderboard')]")
    private WebElement mainAdvertisement;

    @FindBy(xpath = ".//div[@class='w3-example']")
    private List<WebElement> listOfExamples;

    private List<ExampleModel> examplesList;

    public W3SchoolsTagSelectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public W3SchoolsTagSelectPage isAt() {
        webWaitUtils.waitForVisible(mainAdvertisement, Timeouts.MEDIUM);
        return this;
    }

    public W3SchoolsExamplePage clickTryItYourselfButtonByIndex(int index) {
        examplesList = listOfExamples.stream().map(webElement -> new ExampleModel(driver, webElement)).collect(Collectors.toList());
        clickElement(examplesList.get(index).toModel().getTryItYourselfButton());
        return new W3SchoolsExamplePage(driver).isAt();
    }
}
