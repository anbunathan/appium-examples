package com.example.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SmokeSuite {
	public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
	private Addition addition;
	private Divison division;
	private Multiplication mutiplication;
	private Subtraction subtraction;

	@Test
	public void SmokeTest() {
		addition.testAddition();
		subtraction.testSubtract();
		mutiplication.testMultiplication();
		division.testDivision();
	}

	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		// Created object of DesiredCapabilities class.
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "G5 SE");
		caps.setCapability("udid", "LGH8451bb031b0"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.2:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
		addition = new Addition(driver);
		division = new Divison(driver);
		mutiplication = new Multiplication(driver);
		subtraction = new Subtraction(driver);
	}

	@AfterSuite
	public void afterSuite() {
		// Close the driver
		driver.quit();
	}
}
