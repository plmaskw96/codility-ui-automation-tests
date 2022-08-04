package com.gitlab.rmarzec.stepdefs;

import com.gitlab.rmarzec.framework.pages.w3_schools.windows.W3SchoolsCookieWindow;
import org.openqa.selenium.WebDriver;

public class W3SchoolsStepdefs extends BaseStepdefs {

    public W3SchoolsStepdefs(WebDriver driver) {
        super(driver);
    }

    public W3SchoolsStepdefs openTagSelectPage() {
        driver.get("https://www.w3schools.com/tags/tag_select.asp");
        new W3SchoolsCookieWindow(driver)
                .isAt();
        return this;
    }

    public W3SchoolsStepdefs agreeCookies() {
        new W3SchoolsCookieWindow(driver)
                .clickAgreeButton();
        return this;
    }
}
