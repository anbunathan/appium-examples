package com.example.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class firstAppium {
	public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait; 
    @BeforeMethod
	public void setUp() throws MalformedURLException {		
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

	@Test
	public void Sum() {

		System.out.println("Calculate sum of two numbers");
		//Locate elements using By.name() to enter data and click +/= buttons
		driver.findElementById("com.google.android.calculator:id/digit_1").click();
		driver.findElementById("com.google.android.calculator:id/op_add").click();
		driver.findElementById("com.google.android.calculator:id/digit_2").click();
		driver.findElementById("com.google.android.calculator:id/eq").click();
				
		// Get the result text
		WebElement sumOfNumbersEle = driver.
				findElementById("com.google.android.calculator:id/result_final");
		String sumOfNumbers = sumOfNumbersEle.getText();		
		//verify if result is 3
		Assert.assertTrue(sumOfNumbers.endsWith("3"));
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}