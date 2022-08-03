package com.gitlab.rmarzec;

import com.gitlab.rmarzec.stepdefs.google.GoogleStepdefs;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver webDriver;
    protected GoogleStepdefs googleStepdefs;

    protected void initializeStepdefs() {
        googleStepdefs = new GoogleStepdefs(webDriver);
    }
}
