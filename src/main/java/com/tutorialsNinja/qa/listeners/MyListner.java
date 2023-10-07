package com.tutorialsNinja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.project.qa.Utils.Extentreporter;
import com.project.qa.Utils.Utilities;

public class MyListner implements ITestListener {
	ExtentReports extentReport;ExtentTest extentTest;String testName;
	@Override
	public void onStart(ITestContext context) {
extentReport=Extentreporter.generateExtentReport();//static method 
	}
	
	

	@Override
	public void onTestStart(ITestResult result) {
	 testName=	result.getName();
	 extentTest = extentReport.createTest(testName);
	extentTest.log(Status.INFO, testName+"Started Executing");
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//String testName=	result.getName();
		extentTest.log(Status.PASS, testName+"Started Executing");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//String testName=	result.getName();
	//retrive driver 
WebDriver driver =null;
try {
	driver = (WebDriver)	result .getTestClass().getRealClass().getDeclaredField("driver").get(result);
} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	String destinationScreenShotPath=	Utilities.captureScreenShotMethod(driver, testName);

	extentTest.addScreenCaptureFromPath(destinationScreenShotPath);
	extentTest.log(Status.INFO, result.getThrowable());
	extentTest.log(Status.FAIL, testName+"got failed");
	
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//String testName=	result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+"got Skipped");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		//To open ExtentReports automatically 
		/*String pathOfExtentReports=System.getProperty("user.dir"+"");
		File extentReport = new File(pathOfExtentReports);
		Desktop.getDesktop().browse(extentReport);//automatically open Extent reports */
		
	}











































}
