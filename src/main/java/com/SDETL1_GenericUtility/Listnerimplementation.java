package com.SDETL1_GenericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listnerimplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("SDET34L1");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Environment", "TestingEnvironment");
		report.setSystemInfo("Reporter Name", "Bhushana");
		report.setSystemInfo("Platform", "Windows 10");
		report.setSystemInfo("Unit Testing Tool", "TESTNG");
		report.setSystemInfo("Build ManagementTool", "maven");
		report.setSystemInfo("Automation Toll", "Selenium");
		
		
	}	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		test=report.createTest(result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("onTestSuccess");
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		report.flush();
		
	}

}
