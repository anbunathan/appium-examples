package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Token {
    private AndroidDriver<AndroidElement> driver;
    AppiumAPI api = new AppiumAPI();
    String packageName = "uk.co.bitethebullet.android.token";
    String activityName = "uk.co.bitethebullet.android.token.TokenList";
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



            api.clickOnMenuTEXT("Add Token");
            api.clickOnElementRID("tokenTypeSpinner");
            api.clickOnListTEXT("Event Token");
            api.enterStringRID("tokenNameEdit", "hi");
            api.enterStringRID("tokenSerialEdit", "123");
            api.clickOnElementRID("tokenOtpSpinner");
            api.clickOnListTEXT("6");
            api.clickOnElementRID("btnAddStep2");
            api.clickOnRadioButtonTEXT("Direct Seed Entry");
            api.enterStringRID("tokenSeedEdit", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            api.clickOnElementRID("tokenSeedFormat");
            api.clickOnListTEXT("Hex");
            api.clickOnButtonTEXT("COMPLETE");
            api.clickOnMenuTEXT("Change PIN");
            api.enterStringRID("pinChangeNew1Edit", "1234");
            api.enterStringRID("pinChangeNew2Edit", "1234");
            api.clickOnButtonTEXT("SAVE");
            api.clickOnMenuTEXT("Remove Pin");
            api.clickOnButtonTEXT("REMOVE");
            api.clickOnButtonTEXT("OK");
            api.enterStringRID("pinRemoveExistingPinEdit", "1234");
            api.clickOnButtonTEXT("REMOVE");
            api.clickOnListTEXT("hi");
            api.goBack();
            api.clickOnMenuTEXT("Delete Token");
            api.clickOnListTEXT("hi");
            api.clickOnButtonTEXT("OK");
            api.clickOnMenuTEXT("Scan QR");
            api.clickOnButtonTEXT("NO");

            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}