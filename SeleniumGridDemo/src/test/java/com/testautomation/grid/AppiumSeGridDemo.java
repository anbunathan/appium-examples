package com.testautomation.grid;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppiumSeGridDemo {
	@Test
	@Parameters("runOn")
	public void test1(@Optional("ZH33L2Z6KL") String runOn) {
		try {

			System.out.println("Test1 Exceution Started");
			DesiredCapabilities caps = new DesiredCapabilities();
			if (runOn.contains("ZH33L2Z6KL")) {
				caps.setCapability("udid", "ZH33L2Z6KL");
				caps.setCapability("deviceName", "ZH33L2Z6KL");
			} else if (runOn.contains("fca3752eeaac")) {
				caps.setCapability("udid", "fca3752eeaac");
				caps.setCapability("deviceName", "fca3752eeaac");
			}
			caps.setCapability("platformName", "Android");
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("uiautomator2ServerLaunchTimeout", 90000);
			caps.setCapability("appPackage", "com.google.android.calculator");
			caps.setCapability("appActivity", "com.android.calculator2.Calculator");
			caps.setCapability("systemPort", "8201");
			WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), caps);
			Thread.sleep(5000);
			driver.quit();
			System.out.println("Test1 Exceution Ended");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Parameters("runOn")
	public void test2(@Optional("fca3752eeaac") String runOn) {
		try {
			
			System.out.println("Test2 Exceution Started");
			DesiredCapabilities caps = new DesiredCapabilities();
			if(runOn.contains("ZH33L2Z6KL")) {
				caps.setCapability("udid", "ZH33L2Z6KL");
				caps.setCapability("deviceName", "ZH33L2Z6KL");
			}
			else if(runOn.contains("fca3752eeaac")) {
				caps.setCapability("udid", "fca3752eeaac");
				caps.setCapability("deviceName", "fca3752eeaac");
			}
			
			caps.setCapability("platformName", "Android");			
			caps.setCapability("automationName", "UiAutomator2");	
			caps.setCapability("uiautomator2ServerLaunchTimeout", 90000);
			caps.setCapability("appPackage", "com.google.android.calculator");
			caps.setCapability("appActivity", "com.android.calculator2.Calculator");			
			caps.setCapability("systemPort", "8202");
			WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), caps);			
			Thread.sleep(5000);
			driver.quit();
			System.out.println("Test2 Exceution Ended");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
//	@Test
//	public void test3() {
//		try {
//			System.out.println("Test3 Exceution Started");
//			DesiredCapabilities caps = new DesiredCapabilities();
//			caps.setCapability("udid", "ZH33L2Z6KL");
//			caps.setCapability("deviceName", "ZH33L2Z6KL");
//			caps.setCapability("platformName", "Android");			
//			caps.setCapability("automationName", "UiAutomator2");		
//			caps.setCapability("uiautomator2ServerLaunchTimeout", 90000);
//			caps.setCapability("appPackage", "com.google.android.calculator");
//			caps.setCapability("appActivity", "com.android.calculator2.Calculator");			
//			caps.setCapability("systemPort", "8201");
//			WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), caps);			
//			Thread.sleep(5000);
//			driver.quit();
//			System.out.println("Test3 Exceution Ended");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//	@Test
//	public void test4() {
//		try {
//			System.out.println("Test4 Exceution Started");
//			DesiredCapabilities caps = new DesiredCapabilities();
//			caps.setCapability("udid", "fca3752eeaac");
//			caps.setCapability("deviceName", "fca3752eeaac");
//			caps.setCapability("platformName", "Android");			
//			caps.setCapability("automationName", "UiAutomator2");
//			caps.setCapability("uiautomator2ServerLaunchTimeout", 90000);
//			caps.setCapability("appPackage", "com.google.android.calculator");
//			caps.setCapability("appActivity", "com.android.calculator2.Calculator");			
//			caps.setCapability("systemPort", "8202");
//			WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), caps);			
//			Thread.sleep(5000);
//			driver.quit();
//			System.out.println("Test4 Exceution Ended");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
