package com.durgasoft.testNG;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Dynamic_Links {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		WebElement tableLoc = driver.findElement(By.xpath("//div[@class='most-popular']"));
		List<WebElement> links = tableLoc.findElements(By.tagName("a"));
		System.out.println("Available links:" + links.size());
		for (int i = 0; i < links.size(); i++) {
			System.out.println("Link Name:"+links.get(i).getText());
			links.get(i).click();
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(5000);
			//driver.get("http://bbc.com");
			//driver.navigate().to("http://bbc.com");
			driver.navigate().back();
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(5000);
			tableLoc = driver.findElement(By.xpath("//div[@class='most-popular']"));
			links = tableLoc.findElements(By.tagName("a"));
			
		}

	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://bbc.com");
		driver.manage().window().maximize();
	}

}
