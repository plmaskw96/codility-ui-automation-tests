package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.BaseTest;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class Task2Test extends BaseTest {
    @Test
    public void Task2Test(){
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        
    }
}
