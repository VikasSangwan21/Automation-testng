package com.lynx.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import helper.DriverSetup;

public class BaseTest {
	
	
	
	@BeforeClass
	public void setup() {
		System.out.println("Before Class execution");
	}
	
	@AfterClass
	public void tearDownTest() {
		System.out.println("After Class Execution");
		DriverSetup.quitDriver();
	}
	
	
}
