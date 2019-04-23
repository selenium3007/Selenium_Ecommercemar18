package com.durgasoft.ecommerce.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {

	private int retryCount = 0;
	private int maxretryCount = 3;

	public boolean retry(ITestResult arg0) {

		if (retryCount < maxretryCount) {
			log("Retrying Test " + arg0.getName() + " with status " 
						+ getResultStatusName(arg0.getStatus()) + " for the "
													+ (retryCount + 1) + " times ");
			retryCount ++;
			return true;
		}

		return false;
	}

	public void log(String string) {
		Reporter.log(string);

	}

	public String getResultStatusName(int status) {
		String resultName=null;
		if(status==1)
			resultName="SUCCESS";
		if(status==2)
			resultName="FAIL";
		if(status==3)
			resultName="SKIP";
		
		return resultName;
	}

}
