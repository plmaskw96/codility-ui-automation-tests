package com.gitlab.rmarzec.stepdefs;

import com.gitlab.rmarzec.framework.pages.google.home_page.GoogleHomePage;
import com.gitlab.rmarzec.framework.pages.google.home_page.windows.GoogleCookieWindow;
import com.gitlab.rmarzec.framework.pages.google.home_page.windows.GoogleSearchResultsWindow;
import com.gitlab.rmarzec.framework.pages.w3_schools.tags.windows.W3SchoolsCookieWindow;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GoogleStepdefs extends BaseStepdefs {

    public GoogleStepdefs(WebDriver driver) {
        super(driver);
    }

    public GoogleStepdefs openHomePage() {
        //TODO: Get URI from configuration.properties
        driver.get("https://www.google.pl/");
        new GoogleHomePage(driver)
                .isAt();
        return this;
    }

    public GoogleStepdefs agreeCookies() {
        new GoogleCookieWindow(driver)
                .isAt()
                .clickAgreeButton();
        return this;
    }

    public W3SchoolsCookieWindow searchForWithLuckyPick(String text) {
        new GoogleHomePage(driver).enterSearchText(text);
        new GoogleSearchResultsWindow(driver).clickImFellingLuckyButton();
        try {
            return new W3SchoolsCookieWindow(driver).isAt();
        }
        catch (NoSuchElementException ex) {
            System.out.println(driver.getCurrentUrl());
            new W3SchoolsStepdefs(driver).openTagSelectPage();
            return new W3SchoolsCookieWindow(driver).isAt();
        }
    }
}
