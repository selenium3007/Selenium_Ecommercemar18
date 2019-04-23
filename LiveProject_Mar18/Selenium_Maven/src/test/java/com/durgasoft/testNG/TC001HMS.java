package com.durgasoft.testNG;

import org.testng.annotations.Test;
import com.durgasoft.selenium.BasePage;
import com.durgasoft.selenium.PageUI;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import org.testng.annotations.BeforeTest;

public class TC001HMS extends BasePage {
	
	public ATUTestRecorder recorder;
	
	@Test(description = "This test case is to very login & logout in HMS")
	public void login_logout_HMS()throws Exception {
		PageUI p = new PageUI(driver);
		p.verifyLogin();
		p.verifyLogout();
		recorder.stop();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		recorder = new ATUTestRecorder("D:\\recording", "HMSLogin", false);
		recorder.start();
		browserLaunch("firefox", "http://seleniumbymahesh.com");

	}

}
