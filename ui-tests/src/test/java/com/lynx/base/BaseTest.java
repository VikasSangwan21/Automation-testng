package com.lynx.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import helper.DriverSetup;
import utilities.PropertiesReader;

public class BaseTest {
	public static WebDriver driver;
	public ExtentReports extent = null;
	
	@BeforeClass
	public void setup() {
		System.out.println("Before Class execution");
		PropertiesReader.initialiseUiProperties();
		System.out.println(PropertiesReader.property.getProperty("implicitWaitTime"));
		
		// directory where output is to be printed
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\User\\Desktop\\Automation\\Automation-testng\\ui-tests\\reports\\TestResults.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

	}
	
	@BeforeTest
	public void setupTest() {
		System.out.println("Before Test execution");
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\User\\Desktop\\Automation\\Automation-testng\\ui-tests\\reports\\TestResults.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

		ExtentTest report = extent.createTest("New Test");

	}
	
	@AfterTest
	public void teardownTest() {
		System.out.println("After Test execution");
		extent.flush();

	}
	
	@AfterClass
	public void tearDownTest() {
		System.out.println("After Class Execution");
		DriverSetup.quitDriver();
	}
	
	
}
