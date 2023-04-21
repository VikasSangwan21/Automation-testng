package com.lynx.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import helper.DriverSetup;
import utilities.PropertiesReader;

public class BaseTest {
	
	
	
	@BeforeClass
	public void setup() {
		System.out.println("Before Class execution");
		PropertiesReader.initialiseUiProperties();
		System.out.println(PropertiesReader.property.getProperty("implicitWaitTime"));
	}
	
	@AfterClass
	public void tearDownTest() {
		System.out.println("After Class Execution");
		DriverSetup.quitDriver();
	}
	
	
}
