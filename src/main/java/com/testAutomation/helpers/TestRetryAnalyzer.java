package com.testAutomation.helpers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyzer implements IRetryAnalyzer {

    int counter =1;
    int retryMaxLimit = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter<retryMaxLimit){
            counter++;
            return true;
        }
        return false;
    }
}
