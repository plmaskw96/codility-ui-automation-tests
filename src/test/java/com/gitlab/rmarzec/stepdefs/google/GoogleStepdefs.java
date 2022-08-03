package com.gitlab.rmarzec.stepdefs.google;

import com.gitlab.rmarzec.framework.pages.google.GoogleMainPage;
import com.gitlab.rmarzec.framework.pages.google.windows.GoogleCookieWindow;
import com.gitlab.rmarzec.stepdefs.BaseStepdefs;
import org.openqa.selenium.WebDriver;

public class GoogleStepdefs extends BaseStepdefs {


    public GoogleStepdefs(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleStepdefs openApplication() {
        driver.get("https://www.google.pl/");
        new GoogleMainPage(driver)
                .isAt();
        return this;
    }


    public GoogleStepdefs agreeCookies() {
        new GoogleCookieWindow(driver)
                .isAt()
                .clickAgreeButton();
        return this;
    }
}
