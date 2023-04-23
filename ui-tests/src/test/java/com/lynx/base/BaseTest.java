package com.lynx.base;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import helper.DriverSetup;
import interfaces.FrameworkConfig;
import interfaces.UIConfig;
import utilities.ExtentReport;

public class BaseTest {
	public static WebDriver driver;
	public ExtentReports extent = null;
	public static String env = "";
	public static UIConfig uiconfig ;
	
	@BeforeSuite
	public void setup() {
		System.out.println("Before Suite execution");
		FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
		uiconfig = ConfigFactory.create(UIConfig.class);
		System.out.println("Testing environment: "+config.environment());
		extent = ExtentReport.setupReport();
	

	}
	
	@BeforeTest
	public void setupTest() {
		System.out.println("Before Test execution");

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
