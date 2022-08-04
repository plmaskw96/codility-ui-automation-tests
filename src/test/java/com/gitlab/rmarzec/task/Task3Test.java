package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.BaseTest;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task3Test extends BaseTest {

    @BeforeClass
    private void setUp() {
        webDriver = new DriverFactory().initDriver();
        initializeStepdefs();
    }

    @Test
    public void Task3Test() {

        googleStepdefs
                .openHomePage()
                .agreeCookies()
                .searchForWithLuckyPick("HTML select tag - W3Schools");
        w3SchoolsStepdefs
                .agreeCookies();

    }
}
