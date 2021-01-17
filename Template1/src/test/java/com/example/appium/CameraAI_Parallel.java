package com.example.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class CameraAI_Parallel {
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

            } else if (runOn.contains("fca3752eeaac")) {
                caps.setCapability("udid", "fca3752eeaac");
                caps.setCapability("deviceName", "fca3752eeaac");
                caps.setCapability("systemPort", "8202");

            }

            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("autoGrantPermissions", "true");
            caps.setCapability("appium:skipServerInstallation", ImmutableMap.of("w3c",false));
            caps.setCapability("appium:skipServerInstallation", "true");
            caps.setCapability("skipDeviceInitialization", "true");
            caps.setCapability("noReset", "true");
            caps.setCapability("appPackage", "net.sourceforge.opencamera");
            caps.setCapability("appActivity","net.sourceforge.opencamera.MainActivity");
            caps.setCapability("appium:customFindModules", ImmutableMap.of("w3c",false));
            caps.setCapability("appium:shouldUseCompactResponses", ImmutableMap.of("w3c",false));
            HashMap<String, String> customFindModules = new HashMap<String, String>();
            customFindModules.put("ai", "test-ai-classifier");
            caps.setCapability("appium:customFindModules", customFindModules);
            caps.setCapability("appium:shouldUseCompactResponses", false);

            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4444/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.findElement(MobileBy.custom("ai:camera7")).click();
            Thread.sleep(5000);
            driver.findElement(MobileBy.custom("ai:cameraauto")).click();
            driver.findElement(MobileBy.custom("ai:cameraflash")).click();
            driver.findElement(MobileBy.custom("ai:cameralock")).click();
            driver.findElement(MobileBy.custom("ai:camerasetting")).click();
            driver.navigate().back();
            Thread.sleep(5000);
            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}