package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.BaseTest;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.framework.utils.DriverType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task4Test extends BaseTest {

    @BeforeClass
    private void setUp() {
        webDriver = new DriverFactory().initDriver(DriverType.CHROME);
        initializeStepdefs();
    }
    @Test
    public void Task4Test() {
        youtubeStepdefs
                .openHomePage()
                .agreeCookies()
                .printFirstTilesTitleChannelAndLenghtByNumber(12);
    }
}
