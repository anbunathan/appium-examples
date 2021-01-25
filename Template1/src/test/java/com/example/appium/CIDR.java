package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CIDR {
    private AndroidDriver<AndroidElement> driver;
    AppiumAPI api = new AppiumAPI();
    String packageName = "us.lindanrandy.cidrcalculator";
    String activityName = "us.lindanrandy.cidrcalculator.CIDRCalculator";
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
            api.clickOnMenuTEXT("Converter");
            api.enterTextRID("converter_ipaddress", "10.221.11.1");
            api.clickOnElementRID("convertdec");
            api.clickOnElementRID("convertbin");
            api.enterTextRID("iphex", "0a.dd.0b.01");
            api.clickOnElementRID("converthex");
            api.clickOnMenuTEXT("Return IP");
            api.goBack();
            api.clickOnMenuTEXT("IPv6");
            api.clickOnElementRID("ipv6reset");
            api.enterTextRID("ipv6address", "10.221.11.1");
            api.clickOnElementRID("ipv6subnetmasks");
            api.clickOnListTEXT("ffff:ffff:ffff:ffff:fffc:: = /78");
            api.clickOnElementRID("ipv6calculate");
            api.goBack();
            api.clickOnMenuTEXT("Preferences");
            api.clickOnStringTEXT("History Entries");
            api.clickOnListID("0");
            api.clickOnStringTEXT("Input Keyboard");
            api.clickOnListID("0");
            api.clickOnStringTEXT("Notification");
            api.goBack();
            api.clickOnElementRID("bitlength");
            api.clickOnListTEXT("/28");
            api.clickOnElementRID("subnetmask");
            api.clickOnListTEXT("255.255.255.248");
            api.clickOnElementRID("calculate");
            api.clickOnElementRID("reset");
            api.clickOnMenuTEXT("About");
            api.clickOnButtonTEXT("OK");
            api.clickOnMenuTEXT("History");
            api.goBack();

            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}