package com.lynx.test;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.annotations.Test;

import com.lynx.base.BaseTest;

import helper.DriverSetup;
import utilities.EmailUtils;
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
