package com.durgasoft.testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class FaceBook_DD {
	public WebDriver driver;

	@Test
	public void f() throws Exception {
		Thread.sleep(5000);
		/*driver.findElement(By.id("month")).sendKeys("Jul");
		Thread.sleep(5000);
		new Select(driver.findElement(By.id("month"))).selectByIndex(3);
		Thread.sleep(5000);
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("Dec");
		Thread.sleep(5000);
		new Select(driver.findElement(By.id("month"))).selectByValue("6");*/
		WebElement ddMonth = driver.findElement(By.id("month"));
		Select monthDD = new Select(ddMonth);
		monthDD.selectByIndex(6);
		Thread.sleep(5000);
		monthDD.selectByVisibleText("Dec");
		Thread.sleep(5000);
		monthDD.selectByValue("1");
		
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
	}

}
