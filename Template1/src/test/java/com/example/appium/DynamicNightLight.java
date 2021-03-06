package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DynamicNightLight {
    private AndroidDriver<AndroidElement> driver;
    AppiumAPI api = new AppiumAPI();
    String packageName = "de.quaddyservices.dynamicnightlight";
    String activityName = "de.quaddyservices.dynamicnightlight.MainActivity";
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

            } else if (runOn.contains("fca3752eeaac")) {
                caps.setCapability("udid", "fca3752eeaac");
                caps.setCapability("deviceName", "fca3752eeaac");
                caps.setCapability("systemPort", "8202");

            }
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appPackage", packageName);
            caps.setCapability("appActivity", activityName);
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4444/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            api.initializeAPIDriver(driver, packageName, activityName);
            Thread.sleep(5000);

            api.clickOnMenuTEXT("Options");
            api.clickOnStringTEXT("Max. Brightness");
            api.clickOnListTEXT("90%");
            api.EnableCheckboxID("0");
            api.EnableCheckboxID("1");
            api.goBack();



            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}