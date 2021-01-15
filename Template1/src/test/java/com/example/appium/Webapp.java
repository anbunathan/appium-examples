package com.example.appium;

import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Webapp {
    public AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //create Android driver object
        AndroidDriver driver;
        //Initialize the test
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("udid", "ZH33L2Z6KL");
        // Set 'browserName' desired capability. It's Chrome in our case here.
        capabilities.setCapability("browserName", "Chrome");
        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("chromedriverExecutable", "C:\\Program Files\\Appium\\resources\\app"
                + "\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
        capabilities.setCapability("skipUnlock","true");
        // It will launch Chrome app in android device.
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait = new WebDriverWait(driver, 10);
        actualTest(driver);


    }

    public void actualTest(AndroidDriver driver) throws InterruptedException {
        driver.get("http://google.com");
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println("Title is "+title);
        driver.findElementByXPath("//input[@name=\"q\"]").sendKeys("India");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
