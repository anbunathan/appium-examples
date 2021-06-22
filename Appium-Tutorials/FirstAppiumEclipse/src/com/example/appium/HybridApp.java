package com.example.appium;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HybridApp {
	//create Android driver object
	public static AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		//create By object for Webview - android.webkit.WebView
		By webView = By.className("android.webkit.WebView");
		//create Android driver object
		
		//Initialize the test
		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Set android deviceName desired capability. Set your device name.
		capabilities.setCapability("deviceName", "Moto G");
		// Set 'browserName' desired capability. It's Chrome in our case here.
		// capabilities.setCapability("browserName", "Chrome");
		// Set android platformName desired capability. It's Android in our case here.
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("udid", "ZH33L2Z6KL");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("noReset","true");
		capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
//		capabilities.setCapability("chromedriverExecutable", "C:\\Program Files\\Appium\\resources\\app"
//				+ "\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
		//capabilities.setCapability("appPackage", "com.snc.test.webview2");
		//capabilities.setCapability("appActivity", "com.snc.test.webview.activity.MainActivity");
		// Set app path
		capabilities.setCapability("app","D:\\trial\\appium_examples\\Appium-Tutorials\\apps\\WebView-Test.apk");
		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string.
		capabilities.setCapability("skipUnlock","true");
		// It will launch Chrome app in android device.
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.2:4723/wd/hub"),capabilities);
        wait = new WebDriverWait(driver, 300);
		
		//1. Native app part
		//By Id
		//Locate "go website" using its ID and click
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.snc.test.webview2:id/action_go_website"))).click();
		//driver.findElement(By.id("com.snc.test.webview2:id/action_go_website")).click();
		//Allow app permissions
		allowAppPermission();
		//Locate "input URL" field using its ID and type "www.facebook.com"
	    wait.until(ExpectedConditions.visibilityOfElementLocated
	                (By.id("com.snc.test.webview2:id/input_url")));
		WebElement inputurl = driver.findElement(By.id("com.snc.test.webview2:id/input_url"));
		inputurl.clear();
		inputurl.sendKeys("www.google.com");
		//Locate Move button using its name and click
		WebElement movebutton = driver.findElementById("android:id/button1");
		movebutton.click();
		Thread.sleep(5000);
		//Context switch to Webview
		//Create wait object for Webdriver wait
		WebDriverWait wait = new WebDriverWait(driver,300);
		// Wait till Webview element appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(webView));
		// Call getContext() method to return contexts like 'NATIVE_APP' or 'WEBVIEW_1'
		Set<String> availableContexts = driver.getContextHandles();
		System.out.println("Total No of Context  = "+ availableContexts.size());
		//Loop through contexts and select Webview
		for(String context : availableContexts) {
			if(context.contains("WEBVIEW")){
				System.out.println("Context Name is " + context);
				// Call context() method and change it to WEBVIEW_1
				//(This puts Appium session into the web view)
				driver.context(context);
				break;
			}
		}
		//2. Webapp part
		//By Id
		//Locate Email and Password fields using their Ids
		
        
        driver.findElementByXPath("//input[@name=\"q\"]").sendKeys("India");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
	}
	
	public static void allowAppPermission() {
		try{
			//In a loop, check for window with 2 buttons and one button is having name as "Allow"			
			while (driver.findElementsByXPath("//*[@class='android.widget.Button'][2]").size() > 0 &&
					driver.findElementById("com.android.packageinstaller:id/permission_allow_button")
					.getText().contains("Allow"))
			{
				//Click allow button
				driver.findElementByXPath("//*[@class='android.widget.Button'][2]").click();			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
