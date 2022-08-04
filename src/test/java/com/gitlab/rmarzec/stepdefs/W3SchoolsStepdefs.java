package com.gitlab.rmarzec.stepdefs;

import com.gitlab.rmarzec.framework.pages.w3_schools.examples.W3SchoolsExamplePage;
import com.gitlab.rmarzec.framework.pages.w3_schools.tags.W3SchoolsTagSelectPage;
import com.gitlab.rmarzec.framework.pages.w3_schools.tags.windows.W3SchoolsCookieWindow;
import org.openqa.selenium.WebDriver;

public class W3SchoolsStepdefs extends BaseStepdefs {

    public W3SchoolsStepdefs(WebDriver driver) {
        super(driver);
    }

    public W3SchoolsStepdefs openTagSelectPage() {
        //TODO: Get URI from configuration.properties
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

    public W3SchoolsStepdefs openFirstExample() {
        new W3SchoolsTagSelectPage(driver)
                .clickTryItYourselfButtonByIndex(0);
        return this;
    }

    public W3SchoolsStepdefs getResultsHeaderText(StringBuilder textReference) {
        new W3SchoolsExamplePage(driver)
                .getResultsSection()
                .getHeaderText(textReference);
        return this;
    }

    public W3SchoolsStepdefs selectCar(String car) {
        new W3SchoolsExamplePage(driver)
                .getResultsSection()
                .selectCar(car);
        return this;
    }

    public W3SchoolsStepdefs printTextAndValueOfSelectOption(String car) {
        new W3SchoolsExamplePage(driver)
                .getResultsSection()
                .getSelectCarValueAndText(car);
        return this;
    }
}
