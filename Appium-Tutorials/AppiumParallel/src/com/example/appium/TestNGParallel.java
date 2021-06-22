package com.example.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNGParallel {
	AndroidDriver driver;

	@Test
	public void testAddition() {
		// Test case to add 2+4=6 and then assert the result
		// By Id
		// Locate Clear button using its ID and click
		driver.findElement(By.id("com.android.calculator2:id/allClear"))
				.click();
		// By Xpath
		// Locate number button 2 by XPATH element locator and click on it.
		driver.findElement(
				By.xpath("//android.widget.ImageButton[@resource-id='com.android.calculator2:id/digit2']"))
				.click();
		// By Accessibility Id
		// Locate + by Accessibility Id locator and click on it
		driver.findElementByAccessibilityId("Addition").click();
		// By Id
		// Locate digit 4 and equal using their Ids
		WebElement four = driver
				.findElementById("com.android.calculator2:id/digit4");
		four.click();
		WebElement equalTo = driver
				.findElementById("com.android.calculator2:id/equal");
		equalTo.click();
		// By className.
		// Locate result textbox by CLASSNAME element locator and get result
		// from it.
		WebElement results = driver
				.findElementByClassName("com.android.calculator2.CalculatorEditText");
		assert results.getText().contains("6") : "Actual value is : "
				+ results.getText() + " did not match with expected value: 6";
	}

	@Parameters({ "deviceName_", "UDID_", "platformVersion_", "URL_" })
	@BeforeMethod
	public void beforeMethod(String deviceName_,String UDID_,String platformVersion_,String URL_) throws MalformedURLException {
		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Set android deviceName desired capability. Set your device name.
		capabilities.setCapability("deviceName", deviceName_);
		// Set unique device id to identify device
		capabilities.setCapability("udid",UDID_);		
		// Set android VERSION desired capability. Set OS version.
		capabilities.setCapability("platformVersion", platformVersion_);
		// Set BROWSER_NAME desired capability. It's Android in our case here.
		capabilities.setCapability("BROWSER_NAME", "Android");
		// Set android platformName desired capability. It's Android 
		capabilities.setCapability("platformName", "Android");
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appPackage", "com.android.calculator2");
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appActivity",
				"com.android.calculator2.Calculator");
		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string.
		// It will launch calculator app in android device.
		driver = new AndroidDriver(new URL("http://"+URL_),
				capabilities);
		// Add wait delay beteen screen changes and activity launch
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the driver
		driver.quit();
	}

}
