package com.gitlab.rmarzec;

import com.gitlab.rmarzec.stepdefs.GoogleStepdefs;
import com.gitlab.rmarzec.stepdefs.W3SchoolsStepdefs;
import com.gitlab.rmarzec.stepdefs.WikipediaStepdefs;
import com.gitlab.rmarzec.stepdefs.YoutubeStepdefs;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver webDriver;
    protected GoogleStepdefs googleStepdefs;
    protected W3SchoolsStepdefs w3SchoolsStepdefs;
    protected WikipediaStepdefs wikipediaStepdefs;
    protected YoutubeStepdefs youtubeStepdefs;

    protected void initializeStepdefs() {
        googleStepdefs = new GoogleStepdefs(webDriver);
        w3SchoolsStepdefs = new W3SchoolsStepdefs(webDriver);
        wikipediaStepdefs = new WikipediaStepdefs(webDriver);
        youtubeStepdefs = new YoutubeStepdefs(webDriver);
    }
}
