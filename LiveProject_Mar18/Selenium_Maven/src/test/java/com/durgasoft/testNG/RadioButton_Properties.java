package com.durgasoft.testNG;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class RadioButton_Properties {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		WebElement table = driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		for(int k=1;k<3;k++)
		{
		List<WebElement> radio1 = table.findElements(By.name("group"+k));
		System.out.println("Available radio buttons in Group:" + radio1.size());
		for (int i = 0; i < radio1.size(); i++) {
			radio1.get(i).click();
			for (int j = 0; j < radio1.size(); j++) {
				System.out.println(radio1.get(j).getAttribute("value")
						+ "---" + radio1.get(j).getAttribute("checked"));
				Thread.sleep(2000);
			}
		}
		}

	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://echoecho.com/htmlforms10.htm");
		driver.manage().window().maximize();
	}

}
