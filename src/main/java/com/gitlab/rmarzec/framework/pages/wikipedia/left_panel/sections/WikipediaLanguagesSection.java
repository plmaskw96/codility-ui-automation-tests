package com.gitlab.rmarzec.framework.pages.wikipedia.left_panel.sections;

import com.gitlab.rmarzec.framework.utils.WebPage;
import com.gitlab.rmarzec.framework.utils.locators_utils.LocatorListUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WikipediaLanguagesSection extends WebPage {

    @FindBy(xpath = "//nav[@id='p-lang']")
    private WebElement pageContainer;

    @FindBy(xpath = ".//li/a")
    private List<WebElement> languagesList;

    public WikipediaLanguagesSection(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public List<String> getLanguagesList() {
        return new LocatorListUtils(languagesList).getListOfWebelements().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getLanguagesUrl(String country) {
        return new LocatorListUtils(languagesList).getElementFromListByName(country).getAttribute("href");
    }
}
