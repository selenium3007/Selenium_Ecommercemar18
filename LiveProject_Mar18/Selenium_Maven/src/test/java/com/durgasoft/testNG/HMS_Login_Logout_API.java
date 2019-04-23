package com.durgasoft.testNG;

import org.testng.annotations.Test;

import com.durgasoft.excel.Excel_API;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class HMS_Login_Logout_API {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		Excel_API e = new Excel_API("D:\\LiveProject_Mar18\\Selenium_Maven\\testdata\\login.xlsx");
		int noOfRows = e.getRows("Sheet1");
		for (int i = 1; i < noOfRows; i++) {
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys(e.getCellData("Sheet1", 0, i));
			Thread.sleep(3000);
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
	}

}
