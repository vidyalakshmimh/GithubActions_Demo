package org.sherwin.utilities;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation extends ExtentReportManager implements ITestListener {

    public static ExtentTest test;

    public void onTestStart(ITestResult result) {
         test=report.createTest(result.getMethod().getMethodName());
// TODO Auto-generated method stub
    }


    public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Success of test cases and its details are : "+result.getName());
    }


    public void onTestFailure(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Failure of test cases and its details are : "+result.getName());
    }


    public void onTestSkipped(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Skip of test cases and its details are : "+result.getName());
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Failure of test cases and its details are : "+result.getName());
    }


    public void onStart(ITestContext context) {
// TODO Auto-generated method stub
        report=ExtentReportManager.getReport();
    }

    public void onFinish(ITestContext context) {
// TODO Auto-generated method stub
        report.flush();
    }


}
