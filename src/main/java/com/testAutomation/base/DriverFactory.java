package com.testAutomation.base;

import org.openqa.selenium.WebDriver;

/**
 * @author Amit Das
 * This class is used  for creating Thread Locale instance which will be used for parallel execution of testcases
 * Design Pattern - Best Practices for better design of system Architecture
 * 2 design pattern will be implemented
 * 1. Singleton Design pattern -- Only one instance exist  ever
 * 2. Factory Design pattern
 */
public class DriverFactory {

    /**
     * Private Constructor so that no one can create an instance of this class
     * Singleton Design Pattern
     */
    private DriverFactory(){

    }

    /**
     * This private variable refers to instance of this class
     */
    private static DriverFactory instance = new DriverFactory();

    /**
     * This method will return the instance of current class -- Singleton Pattern
     * @return
     */
    public static DriverFactory getInstance(){
        return instance;
    }

    /**
     * Factory Design Pattern -- We are going to define separate factory methods for creating objects and crete objects by calling that method
     */
    ThreadLocal<WebDriver> threadLocal =  new ThreadLocal<WebDriver>();

    public WebDriver getDriver(){
        return threadLocal.get();
    }

    public void setDriver(WebDriver driverParam){
        threadLocal.set(driverParam);
    }

    public void closeBrowser(){
        threadLocal.get().close();
        threadLocal.remove();
    }

}
