package com.example.appium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class Divison {
	// Create driver object
	AndroidDriver driver;
	
	
	public Divison(AndroidDriver driver) {
		super();
		this.driver = driver;
	}

	public void testDivision() {
		// Test case to add 8/4=2 and then assert the result
		// By Id
		// Locate Clear button using its ID and click
		driver.findElement(By.id("com.android.calculator2:id/allClear"))
				.click();
		// By Xpath
		// Locate number button 8 by XPATH element locator and click on it.
		driver.findElement(
				By.xpath("//android.widget.ImageButton[@resource-id='com.android.calculator2:id/digit8']"))
				.click();
		// By Accessibility Id
		// Locate / by Accessibility Id locator and click on it
		driver.findElementByAccessibilityId("Division").click();
		// By Id
		// Locate digit 4 and equal using their Ids
		WebElement four = driver.findElementById("com.android.calculator2:id/digit4");
		four.click();
		WebElement equalTo = driver.findElementById("com.android.calculator2:id/equal");
		equalTo.click();
		// By className.
		// Locate result textbox by CLASSNAME element locator and get result
		// from it.
		WebElement results = driver
				.findElementByClassName("com.android.calculator2.CalculatorEditText");
		assert results.getText().contains("2") : "Actual value is : "
				+ results.getText() + " did not match with expected value: 2";
	}

	

}
