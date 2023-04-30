package com.lynx.base;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import helper.DriverSetup;
import interfaces.FrameworkConfig;
import interfaces.UIConfig;
import utilities.EmailUtils;
import utilities.ExcelReader;
import utilities.ExtentReport;

public class BaseTest {
	public static WebDriver driver;
	public ExtentReports extent = null;
	public static String env = "";
	public static UIConfig uiconfig ;
	public static ExcelReader testDataExcel;
	
	@BeforeSuite
	public void setup() {
		System.out.println("Before Suite execution");
		System.setProperty("project.path", System.getProperty("user.dir").replace("\\ui-tests", ""));
		FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
		uiconfig = ConfigFactory.create(UIConfig.class);
		System.out.println("Testing environment: "+config.environment());
		extent = ExtentReport.setupReport();
		testDataExcel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/test-data/TestData.xlsx","sheet1");
	

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
	
	@AfterSuite
	public void tearDownTest() {
		System.out.println("After Class Execution");
		DriverSetup.quitDriver();
		 EmailUtils.sendMail();
	}
	
	
}
