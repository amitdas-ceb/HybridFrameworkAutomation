package com.testAutomation.helpers;

import com.aventstack.extentreports.Status;
import com.testAutomation.base.DriverFactory;
import com.testAutomation.base.ExtentFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionEngine {

    public void send_keys(WebElement element,String fieldName, String value){
        try{
            element.sendKeys(value);
            //log success message in Extent Report
            ExtentFactory.getInstance().getExtentLocal().log(Status.PASS, fieldName + " is updated with value : "+ value);
        }catch (Exception e){
            //log failure message iin Extent Report
            ExtentFactory.getInstance().getExtentLocal().log(Status.FAIL, "Unable to send Keys : "+ e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickElement(WebElement element,String fieldName){
        try{
            element.click();
            //log success message in Extent Report
            ExtentFactory.getInstance().getExtentLocal().log(Status.PASS, "Successfully clicked on field : "+ fieldName);
        }catch (Exception e){
            //log failure message iin Extent Report
            ExtentFactory.getInstance().getExtentLocal().log(Status.FAIL, "Unable to click element : "+fieldName+ "-->"+ e.getMessage());
            e.printStackTrace();
        }
    }
}
