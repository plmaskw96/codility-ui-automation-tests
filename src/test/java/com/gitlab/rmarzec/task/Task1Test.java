package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.BaseTest;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.framework.utils.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class Task1Test extends BaseTest {

    @Test
    public void Task1Test(){
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver(DriverType.CHROME);
        webDriver.get("https://www.onet.pl/");
    }
}
