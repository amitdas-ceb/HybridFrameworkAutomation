package com.testAutomation.helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testAutomation.base.DriverFactory;
import com.testAutomation.base.ExtentFactory;
import com.testAutomation.base.ExtentReportNG;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ListenerImplementation implements ITestListener {

    static ExtentReports report;
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult iTestResult) {
        //Before each test start
        test = report.createTest(iTestResult.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtentLocal(test);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentFactory.getInstance().getExtentLocal().log(Status.PASS, "Test case : "+iTestResult.getMethod().getMethodName() + " is Passed");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentFactory.getInstance().getExtentLocal().log(Status.FAIL, "Test case : "+iTestResult.getMethod().getMethodName() + " is Failed");
        ExtentFactory.getInstance().getExtentLocal().log(Status.FAIL,iTestResult.getThrowable());

        //Screenshot on Failure

        File src = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("_dd-MM-yyyy__HH-mm-ss_");
        String formattedDate = myDateObj.format(myFormatObj);
        String screenshotPath = System.getProperty("user.dir")+"/target/reports/screenshots/"+iTestResult.getMethod().getMethodName()+formattedDate+".jpeg";
        File dest = new File(screenshotPath);
        try{
            FileUtils.copyFile(src,dest);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ExtentFactory.getInstance().getExtentLocal().addScreenCaptureFromPath(screenshotPath,"Test case Failure screenshot");
            ExtentFactory.getInstance().removeExtentObject();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentFactory.getInstance().getExtentLocal().log(Status.SKIP, "Test case : "+iTestResult.getMethod().getMethodName() + " is Skipped");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //setup method call
        report = ExtentReportNG.setupExtentReport();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //Close extent
        report.flush();
    }
}
