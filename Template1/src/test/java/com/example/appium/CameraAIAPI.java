package com.example.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CameraAIAPI {


    private AndroidDriver<AndroidElement> driver;
    AppiumAPI api = new AppiumAPI();
    String packageName = "com.snc.test.webview2";
    String activityName = "com.snc.test.webview.activity.SplashActivity";

    @Test
    public void installTest() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "MotoG");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("udid", "ZH33L2Z6KL");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("skipDeviceInitialization", "true");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("appPackage", "net.sourceforge.opencamera");
        capabilities.setCapability("appActivity","net.sourceforge.opencamera.MainActivity");
        HashMap<String, String> customFindModules = new HashMap<String, String>();
        customFindModules.put("ai", "test-ai-classifier");
        capabilities.setCapability("appium:customFindModules", ImmutableMap.of("w3c",false));
        capabilities.setCapability("appium:customFindModules", customFindModules);
        capabilities.setCapability("appium:skipServerInstallation", ImmutableMap.of("w3c",false));
        capabilities.setCapability("appium:skipServerInstallation", "true");
        capabilities.setCapability("appium:shouldUseCompactResponses", ImmutableMap.of("w3c",false));

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        api.initializeAPIDriver(driver, packageName, activityName);
        api.waitInMS("5000");

        api.clickOnAIElement("camera7");
        api.waitInMS("5000");
        api.clickOnAIElement("cameraauto");
        api.clickOnAIElement("cameraflash");
        api.clickOnAIElement("cameralock");
        api.clickOnAIElement("camerasetting");
        api.goBack();
        api.waitInMS("5000");
        driver.quit();
    }
}
