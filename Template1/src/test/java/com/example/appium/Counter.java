package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Counter {
    private AndroidDriver<AndroidElement> driver;
    AppiumAPI api = new AppiumAPI();
    String packageName = "me.tsukanov.counter.ui";
    String activityName = "me.tsukanov.counter.ui.MainActivity";
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
            api.clickOnMenuTEXT("Settings");
            api.EnableCheckboxID("0");
            api.EnableCheckboxID("1");
            api.EnableCheckboxID("2");
            api.EnableCheckboxID("3");
            api.clickOnStringTEXT("Theme");
            api.clickOnListID("0");
            api.clickOnStringTEXT("Remove all counters");
            api.clickOnButtonTEXT("CANCEL");
            api.goBack();
            api.clickOnImageButtonID("0");
            api.clickOnStringTEXT("Add counter");
            api.enterTextRID("edit_name", "hi");
            api.enterTextRID("edit_value", "2");
            api.clickOnButtonTEXT("CANCEL");
            api.clickOnStringTEXT("Add counter");
            api.enterTextRID("edit_name", "hi");
            api.enterTextRID("edit_value", "2");
            api.clickOnButtonTEXT("ADD");
            api.clickOnElementRID("incrementButton");
            api.clickOnElementRID("menu_reset");
            api.clickOnButtonTEXT("RESET");
            api.clickOnElementRID("menu_edit");
            api.clickOnButtonTEXT("APPLY");
            api.clickOnMenuTEXT("Delete counter");
            api.clickOnButtonTEXT("DELETE");

            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}