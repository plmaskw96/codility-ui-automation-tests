package com.gitlab.rmarzec;

import com.gitlab.rmarzec.stepdefs.GoogleStepdefs;
import com.gitlab.rmarzec.stepdefs.W3SchoolsStepdefs;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver webDriver;
    protected GoogleStepdefs googleStepdefs;
    protected W3SchoolsStepdefs w3SchoolsStepdefs;

    protected void initializeStepdefs() {
        googleStepdefs = new GoogleStepdefs(webDriver);
        w3SchoolsStepdefs = new W3SchoolsStepdefs(webDriver);
    }
}