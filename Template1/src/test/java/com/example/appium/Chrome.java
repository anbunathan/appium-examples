package com.example.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Chrome {
    WebDriver driver;
    DesiredCapabilities cap = new DesiredCapabilities();
    @BeforeClass
    public void init() throws MalformedURLException {
        cap.setCapability("deviceName", "ZH33L2Z6KL");
        cap.setCapability("platformName", "Android");
        cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability("chromeDriverPort", "8201");
        cap.setCapability("chromedriverExecutable","C:\\chromedriver\\chromedriver.exe");
        cap.setCapability(CapabilityType.VERSION, "5.1");
    }

    @Test
    public void testApp() {
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://www.amazon.com");
    }
}