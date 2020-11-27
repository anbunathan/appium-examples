package com.example.appium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Chrome {

    WebDriver driver;
    DesiredCapabilities cap = new DesiredCapabilities();

    @BeforeClass
    public void init() throws MalformedURLException {

        cap.setCapability("deviceName", "ZH33L2Z6KL");
        cap.setCapability("platformName", "Android");
        cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability("chromedriverExecutable","C:\\chromedriver\\chromedriver.exe");
        cap.setCapability(CapabilityType.VERSION, "5.1");

    }

    @Test
    public void testApp() {

        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://www.amazon.com");

    }

}