package org.AppiumAutomationFramework.TestCases.TestCases_android;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;

public class ExtentReporterNG {

   static ExtentReports extent;
    @BeforeTest
    public static  ExtentReports addExtentReport(){

        String path = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web automation");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("tester","eslam");

        return extent;
    }


}
