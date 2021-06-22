package com.example.appium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestNGDemo {
	// Create driver object
	public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait; 
	@Test
	public void testAddition() {
		// Test case to add 2+4=6 and then assert the result
		// By Id
		// Locate Clear button using its ID and click
		TouchActions action = new TouchActions(driver);		
		action.longPress(driver.findElement(By.id("com.google.android.calculator:id/del")));	
		action.perform();
		// By Xpath
		// Locate number button 2 by XPATH element locator and click on it.
		driver.findElementById("com.google.android.calculator:id/digit_2").click();
		// By Accessibility Id
		// Locate + by Accessibility Id locator and click on it
		driver.findElementById("com.google.android.calculator:id/op_add").click();
		// By Id
		// Locate digit 4 and equal using their Ids
		WebElement four = driver.findElementById("com.google.android.calculator:id/digit_4");
		four.click();
		WebElement equalTo = driver.findElementById("com.google.android.calculator:id/eq");
		equalTo.click();
		// By className.
		// Locate result textbox by CLASSNAME element locator and get result
		// from it.
		WebElement sumOfNumbersEle = driver.
				findElementById("com.google.android.calculator:id/result_final");
		String sumOfNumbers = sumOfNumbersEle.getText();		
		//verify if result is 3
		Assert.assertTrue(sumOfNumbers.endsWith("6"));
	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Moto G");
		caps.setCapability("udid", "ZH33L2Z6KL"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.google.android.calculator");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.2:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
	}
	@AfterTest
	public void afterTest() {
		// Close the driver
		driver.quit();
	}

}
