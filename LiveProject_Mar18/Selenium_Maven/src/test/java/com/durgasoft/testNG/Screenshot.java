package com.durgasoft.testNG;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshot {

	public WebDriver driver;

	@Test(enabled = false)
	public void normalScreenshot() throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Mahesh\\Desktop\\sbm.png"));
	}

	@Test(enabled = false)
	public void conditionBasedScreenshot() throws Exception {
		List<WebElement> links = driver.findElements(By.partialLinkText("New Batches"));
		System.out.println("Available links:" + links.size());
		for (int i = 0; i < links.size(); i++) {
			System.out.println("Links Name:" + links.get(i).getText());
			links.get(i).click();
			Thread.sleep(5000);
		}
		if (!(links.size() == 0)) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Mahesh\\Desktop\\sbm.png"));
		}
	}

	@Test(enabled = false)
	public void functionalBasedScreenshot() throws Exception {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Available links:" + links.size());
		for (int i = 0; i < links.size(); i++) {
			String linkName = links.get(i).getText();
			System.out.println(linkName);
			links.get(i).click();
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Mahesh\\Desktop\\screenshot\\" + linkName + ".png"));
			links = driver.findElements(By.tagName("a"));
		}
	}

	@Test(enabled = false)
	public void dateNTimeScreenshot() throws Exception {
		Date dt = new Date();
		DateFormat dtFormat = new SimpleDateFormat("dd-MM-yyy-hh-mm-ss");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Mahesh\\Desktop\\" + dtFormat.format(dt) + "sbm.png"));

	}

	@Test
	public void passedScreenshot() throws Exception {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Available links:" + links.size());
		for (int i = 0; i < links.size(); i++) {
			String linkName = links.get(i).getText();
			System.out.println(linkName);
			links.get(i).click();
			if (driver.getTitle().contains("Register: Mercury Tours")) {
				Date dt = new Date();
				DateFormat dtFormat = new SimpleDateFormat("dd-MM-yyy-hh-mm-ss");
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File(
						"C:\\Users\\Mahesh\\Desktop\\screenshot\\" + linkName + "----" + dtFormat.format(dt) + ".png"));
			}
			links = driver.findElements(By.tagName("a"));
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://www.newtours.demoaut.com/");
		driver.manage().window().maximize();
	}

}
