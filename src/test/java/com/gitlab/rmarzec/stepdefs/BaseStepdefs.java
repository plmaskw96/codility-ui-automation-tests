package com.gitlab.rmarzec.stepdefs;

import org.openqa.selenium.WebDriver;

public abstract class BaseStepdefs {

    protected WebDriver driver;

    public BaseStepdefs(WebDriver driver) {
        this.driver = driver;
    }
}
