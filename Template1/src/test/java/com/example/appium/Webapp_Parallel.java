package com.example.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Webapp_Parallel {
    private AndroidDriver<MobileElement> driver;
    @Test
    @Parameters("runOn")
    public void test(@Optional("ZH33L2Z6KL") String runOn) {
        try {
            System.out.println("Test1 Exceution Started");
            DesiredCapabilities caps = new DesiredCapabilities();
            if (runOn.contains("ZH33L2Z6KL")) {
                caps.setCapability("udid", "ZH33L2Z6KL");
                caps.setCapability("deviceName", "ZH33L2Z6KL");
                caps.setCapability("systemPort", "8201");
                caps.setCapability("browserName", "Chrome");

            } else if (runOn.contains("fca3752eeaac")) {
                caps.setCapability("udid", "fca3752eeaac");
                caps.setCapability("deviceName", "fca3752eeaac");
                caps.setCapability("systemPort", "8202");
                caps.setCapability("browserName", "Chrome");

            }

            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("chromedriverExecutable", "C:\\Program Files\\Appium\\resources\\app"
                    + "\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
            caps.setCapability("skipUnlock","true");
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4444/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            Thread.sleep(5000);
            actualTest(driver);
            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
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