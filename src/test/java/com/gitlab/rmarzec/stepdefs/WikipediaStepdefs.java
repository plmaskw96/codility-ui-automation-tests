package com.gitlab.rmarzec.stepdefs;

import com.gitlab.rmarzec.framework.pages.wikipedia.hoempage.WikipediaHomePage;
import com.gitlab.rmarzec.framework.pages.wikipedia.left_panel.WikipediaLeftPanelPage;
import org.openqa.selenium.WebDriver;

public class WikipediaStepdefs extends BaseStepdefs {

    public WikipediaStepdefs(WebDriver driver) {
        super(driver);
    }

    public WikipediaStepdefs openHomePage() {
        driver.get("https://pl.wikipedia.org/wiki/Wiki");
        new WikipediaHomePage(driver).isAt();
        return this;
    }

    public WikipediaStepdefs printLanguagesList() {
        new WikipediaLeftPanelPage(driver)
                .getLanguagesSection()
                .getLanguagesList()
                .stream()
                .forEach(System.out::println);
        return this;
    }

    public WikipediaStepdefs printLanguageUrl(String country) {
        System.out.println(
                new WikipediaLeftPanelPage(driver)
                .getLanguagesSection()
                .getLanguagesUrl(country)
        );
        return this;
    }
}
