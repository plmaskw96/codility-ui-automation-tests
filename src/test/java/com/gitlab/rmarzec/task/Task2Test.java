package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.BaseTest;
import com.gitlab.rmarzec.framework.dataProvider.TestDataProvider;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Task2Test extends BaseTest {


    @BeforeClass
    private void setUp() {
        webDriver = new DriverFactory().initDriver();
        initializeStepdefs();
    }

    @Test
    public void Task2Test(){
        
        wikipediaStepdefs
                .openHomePage()
                .printLanguagesList()
                .printLanguageUrl(TestDataProvider.COUNTRY_NAME);
    }
}
