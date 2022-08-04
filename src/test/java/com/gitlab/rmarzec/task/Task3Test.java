package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.BaseTest;
import com.gitlab.rmarzec.framework.dataProvider.TestDataProvider;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.framework.utils.DriverType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task3Test extends BaseTest {

    @BeforeClass
    private void setUp() {
        webDriver = new DriverFactory().initDriver(DriverType.CHROME);
        initializeStepdefs();
    }

    @Test
    public void Task3Test() {
        StringBuilder exampleResultHeader = new StringBuilder();

        googleStepdefs
                .openHomePage()
                .agreeCookies()
                .searchForWithLuckyPick(TestDataProvider.SEARCHED_TAG);
        w3SchoolsStepdefs
                .agreeCookies()
                .openFirstExample()
                .getResultsHeaderText(exampleResultHeader);
        System.out.println(exampleResultHeader);
        w3SchoolsStepdefs
                .selectCar(TestDataProvider.CAR_NAME)
                .printTextAndValueOfSelectOption(TestDataProvider.CAR_NAME);

    }
}
