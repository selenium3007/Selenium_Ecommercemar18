package com.durgasoft.testNG;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedBus_Alert {
	public WebDriver driver;

	@Test
	public void f() throws Exception {
		driver.findElement(By.id("i-icon-profile")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("signInLink")).click();
		Thread.sleep(6000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Sign in with Facebook']")).click();
		Thread.sleep(6000);
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		Object s[]=windows.toArray();
		driver.switchTo().window(s[1].toString());
		driver.findElement(By.id("email")).sendKeys("Sunny");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://redbus.in");
		driver.manage().window().maximize();
	}

}
