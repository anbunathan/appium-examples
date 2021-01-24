package com.example.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Calculator3 {
    private AndroidDriver<AndroidElement> driver;
    AppiumAPI api = new AppiumAPI();
    String packageName = "com.android.calculator3";
    String activityName = "com.android.calculator3.Calculator";
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
            api.clickOnMenuXPATH("//android.widget.TextView[@text='Clear history']");
            api.assertTrueXPATH("//android.widget.EditText[@index='0']","");
            api.clickOnElementRID("digit2");
            api.clickOnElementRID("plus");
            api.clickOnElementRID("digit4");
            api.clickOnElementRID("equal");
            api.assertTrueXPATH("//android.widget.EditText[@index='0']","6");
            api.clickOnMenuXPATH("//android.widget.TextView[@text='Clear history']");
            api.clickOnElementRID("digit1");
            api.clickOnElementRID("digit0");
            api.clickOnElementRID("digit0");
            api. clickLongOnElementXPATH("//android.widget.EditText[@index='0']");
            api.clickListXPATH("//android.widget.TextView[@text='Cut']");
            Thread.sleep(5000);
            api. clickLongOnElementXPATH("//android.widget.EditText[@index='0']");
            api.clickListXPATH("//android.widget.TextView[@text='Paste']");
            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}