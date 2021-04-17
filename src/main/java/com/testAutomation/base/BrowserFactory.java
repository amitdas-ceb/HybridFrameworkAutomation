package com.testAutomation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

/**
 * @author Amit Das
 * This class is used for Parallel Execution of tests
 */

public class BrowserFactory {

    /**
     * This method will create WebDriver Object for given browser
     * @param browser
     */
    public WebDriver createBrowserInstance(String browser){

        WebDriver driver = null;
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.addArguments("--private");
                driver = new FirefoxDriver(fOptions);
                break;
            case "ie" :
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.addCommandSwitches("--private");
                driver = new InternetExplorerDriver(ieOptions);
                break;
            default:
                System.out.println("Wrong Browser Entered/ Browser not Supported");
                break;
        }
        return driver;
    }
}
