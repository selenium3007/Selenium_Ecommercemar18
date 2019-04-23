package com.durgasoft.testNG;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class DynamicWebCalender {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]")).click();
		Thread.sleep(5000);

		// Departure Date
		String date = "30-July 2019";
		String[] ddSplitter = date.split("-");
		String depDate = ddSplitter[0];
		String depMonth = ddSplitter[1];
		selectDate(depDate, depMonth);
		
		//Return Date
		driver.findElement(By.xpath("//*[@id='Div1']/button")).click();
		Thread.sleep(5000);
		String rdate = "30-October 2019";
		String[] rsplitter = rdate.split("-");
		String returnDate=rsplitter[0];
		String returnMonth=rsplitter[1];
		selectDate(returnDate, returnMonth);

	}

	public void selectDate(String depDate, String depMonth) throws Exception {
		List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div/div/div"));
		System.out.println(elements.size());
		for (int i = 0; i < elements.size(); i++) {
			i=0;
			System.out.println(elements.get(i).getText());
			if (elements.get(i).getText().equalsIgnoreCase(depMonth)) {
					List<WebElement> tableData = driver.findElements(By.xpath
				("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td/a"));
					for(WebElement d:tableData) {
						System.out.println(d.getText());
						if(d.getText().equalsIgnoreCase(depDate)) {
							d.click();
							break;
						}
						
					}
					break;
			} else {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(5000);
				elements = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div/div/div"));
			}
		}

	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
	}

}
