package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidCalcAppExample {
	WebDriver driver;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
    
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
        appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);
        
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZH33L2Z6KL");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		driver = new AndroidDriver<>(new URL(appiumServiceUrl), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void Sum() {
		System.out.println("Calculate sum of two numbers");
		// Locate elements to enter data and click +/= buttons
		driver.findElement(By.xpath("//*[@text='1']")).click();
		driver.findElement(By.xpath("//*[@text='+']")).click();
		driver.findElement(By.xpath("//*[@text='2']")).click();
		driver.findElement(By.xpath("//*[@content-desc='equals']")).click();

		// Get the result text
		WebElement sumOfNumbersEle = driver.findElement(By.className("android.widget.EditText"));
		String sumOfNumbers = sumOfNumbersEle.getText();

		// verify if result is 3
		Assert.assertTrue(sumOfNumbers.endsWith("3"));
	}

	@AfterTest
	public void End() {
		System.out.println("Stop driver");
		driver.quit();
		System.out.println("Stop appium service");
		appiumService.stop();
	}

}