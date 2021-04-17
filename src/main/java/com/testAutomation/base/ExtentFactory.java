package com.testAutomation.base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentFactory {

    private ExtentFactory(){

    }

    /**
     * This private variable refers to instance of this class
     */
    private static ExtentFactory instance = new ExtentFactory();

    /**
     * This method will return the instance of current class -- Singleton Pattern
     * @return
     */
    public static ExtentFactory getInstance(){
        return instance;
    }

    /**
     * Factory Design Pattern -- We are going to define separate factory methods for creating objects and crete objects by calling that method
     */
    ThreadLocal<ExtentTest> extentLocal =  new ThreadLocal<ExtentTest>();

    public ExtentTest getExtentLocal(){

        return extentLocal.get();
    }

    public void setExtentLocal(ExtentTest extentTestObject){
        extentLocal.set(extentTestObject);
    }

    public void removeExtentObject(){
        extentLocal.remove();
    }

}
