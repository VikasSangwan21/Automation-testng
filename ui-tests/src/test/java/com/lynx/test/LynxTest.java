package com.lynx.test;

import org.testng.annotations.Test;

import com.lynx.base.BaseTest;

import helper.DriverSetup;
import utilities.GeneralUtils;

public class LynxTest extends BaseTest{

	@Test
	public void test1() {
		System.out.println("Execution test1");
		DriverSetup.initDriver();
		GeneralUtils.testUtils();
	}

}
