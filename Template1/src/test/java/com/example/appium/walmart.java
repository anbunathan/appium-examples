package com.example.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class walmart {
    public static AndroidDriver<MobileElement> driver;

    @Test
    public void installTest() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "MotoG");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("udid", "ZH33L2Z6KL");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("skipServerInstallation", "true");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("skipDeviceInitialization", "true");
        capabilities.setCapability("noReset", "true");



        capabilities.setCapability("appPackage", "com.walmart.mg'");
        capabilities.setCapability("appActivity","com.mx.walmart.walmartgroceries.MainActivity'");


        HashMap<String, String> customFindModules = new HashMap<String, String>();
        customFindModules.put("ai", "test-ai-classifier");

        capabilities.setCapability("customFindModules", customFindModules);
        capabilities.setCapability("shouldUseCompactResponses", false);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        Thread.sleep(15000);

        driver.findElement(MobileBy.custom("ai:cart")).click();
        Thread.sleep(5000);
        driver.findElement(MobileBy.custom("ai:arrow_left")).click();
        driver.navigate().back();

        Thread.sleep(5000);
        driver.quit();

    }
}
