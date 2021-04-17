package com.testAutomation.base;

import com.testAutomation.helpers.ActionEngine;
import com.testAutomation.helpers.CommonHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Amit Das
 * This is test base class
 */
public class BaseTest extends ActionEngine {

    BrowserFactory browserFactory = new BrowserFactory();
    CommonHelpers commonHelpers = new CommonHelpers();

    @BeforeMethod
    public void launchApplication(){
        DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance("chrome"));
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Properties prop = commonHelpers.getFileProperties("src/test/resources/config.properties");
        driver.navigate().to(prop.getProperty("app_url"));
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getInstance().closeBrowser();
    }

}
