package com.example.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.Set;


public class HybridappAPI {
    private AndroidDriver<MobileElement> driver;
    AppiumAPI api = new AppiumAPI();
    String packageName = "com.snc.test.webview2";
    String activityName = "com.snc.test.webview.activity.SplashActivity";
    public static WebDriverWait wait;
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
            caps.setCapability("app","D:\\Webapp\\app\\WebView-Test.apk");
            caps.setCapability("chromedriverExecutable", "C:\\Program Files\\Appium\\resources\\app"
                    + "\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
            caps.setCapability("autoGrantPermissions", "true");

            // It will launch Chrome app in android device.
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4444/wd/hub"),caps);
            wait = new WebDriverWait(driver, 300);
            api.initializeAPIDriver(driver, packageName, activityName);
            Thread.sleep(5000);

            api.clickOnWebElementWaitRID("action_go_website");
            api.clickOnWebElementWaitRID("input_url");
            api.enterStringRID("input_url","http://google.com");
            api.clickOnButtonTEXT("GO");
            api.waitInMS("5000");
            api.assertOnWebElementWaitCLASS("android.webkit.WebView");
            api.setWebviewContext("WEBVIEW_com");
            api.enterWebTEXT("\"q\"", "India");
            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}