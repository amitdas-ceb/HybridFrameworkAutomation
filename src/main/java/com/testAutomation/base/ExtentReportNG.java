package com.testAutomation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExtentReportNG {

    static ExtentReports extent;

    public static ExtentReports setupExtentReport(){

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("_dd-MM-yyyy__HH-mm-ss_");
        String formattedDate = myDateObj.format(myFormatObj);
        String reportPath = System.getProperty("user.dir")+"/target/reports/ExecutionReport"+formattedDate+".html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setDocumentTitle("Extent Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Report Summary");
        extent.setSystemInfo("Executed on Env : ","prod");
        extent.setSystemInfo("Executed on Browser : ","chrome");
        return extent;
    }
}
