package com.gitlab.rmarzec.framework.pages.w3_schools.examples.sections;

import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;


public class W3SchoolsExampleResultsSection extends WebPage {

    @FindBy(xpath = "//iframe[@id='iframeResult']")
    private WebElement frameLocator;

    @FindBy(xpath = "//body")
    private WebElement pageContainer;

    @FindBy(xpath = ".//h1")
    private WebElement headerText;

    @FindBy(xpath = ".//select")
    private WebElement carSelect;

    public W3SchoolsExampleResultsSection(WebDriver driver) {
        super(driver);
        driver.switchTo().defaultContent();
        switchToFrame(frameLocator);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public W3SchoolsExampleResultsSection getHeaderText(StringBuilder textReference) {
        textReference.append(headerText.getText());
        return this;
    }

    public W3SchoolsExampleResultsSection selectCar(String option) {
        selectOption(carSelect, option);
        return this;
    }

    public W3SchoolsExampleResultsSection getSelectCarValueAndText(String option) {
        WebElement element = getSelectOption(carSelect, option);
        System.out.println(element.getAttribute("innerHTML"));
        System.out.println(element.getAttribute("value"));
        return this;
    }
}
