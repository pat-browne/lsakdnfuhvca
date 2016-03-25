package com.techportal.utilities;

import org.testng.*;

import java.io.IOException;

/**
 * Created by Patrick.Browne on 2/5/2016.
 */
public class MyTestListener extends TestListenerAdapter{

    public static MyTestResults results = new MyTestResults();

    @Override
    public void onTestSuccess(ITestResult testResult){
        System.out.println(testResult.getName() + " Was Successful.");
        //Record Results
        results.incrementPassed();
        System.out.println("PASSED TESTS: " + results.getPassed());
    }

    @Override
    public void onTestFailure(ITestResult testResult){
        System.out.println(testResult.getName() + " Has Failed. \n Throwable: " + testResult.getThrowable().getMessage());
        //Screenshot
        //Record Results
        results.incrementFailed();
        System.out.println("TESTS FAILED: " + results.getFailed());
    }

    @Override
    public void onTestSkipped(ITestResult testRresult){
        System.out.println(testRresult.getName() + " Was Skipped.");
        results.incrementSkipped();
        System.out.println("SKIPPED TEST: " + results.getSkipped());
    }

    @Override
    public void onFinish(ITestContext testContext){
            results.writeResultsCSV();
            results.writeResultsText();
    }
}
