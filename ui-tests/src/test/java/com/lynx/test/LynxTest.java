package com.lynx.test;

import org.testng.annotations.Test;

import com.lynx.base.BaseTest;

import helper.DriverSetup;
import utilities.GeneralUtils;
import utilities.TestDataReader;

public class LynxTest extends BaseTest{
	
	@Test
	public void test1() {
		System.out.println("Execution test1");
		driver = DriverSetup.initDriver();
		GeneralUtils.testUtils();
		driver.get(uiconfig.URL());
	}

}
