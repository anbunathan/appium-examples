package com.example.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestCameraAI {


    private static AndroidDriver driver;

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


//        capabilities.setCapability("appPackage", "com.motorola.camera");
//        capabilities.setCapability("appActivity","com.motorola.camera.Camera");
        capabilities.setCapability("appPackage", "net.sourceforge.opencamera");
        capabilities.setCapability("appActivity","net.sourceforge.opencamera.MainActivity");
//        capabilities.setCapability("appPackage", "photo.camera.hdcameras");
//        capabilities.setCapability("appActivity","com.android.camera.H5View");

        HashMap<String, String> customFindModules = new HashMap<String, String>();
        customFindModules.put("ai", "test-ai-classifier");

        capabilities.setCapability("customFindModules", customFindModules);
        capabilities.setCapability("shouldUseCompactResponses", false);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        Thread.sleep(15000);

        driver.findElement(MobileBy.custom("ai:camera7")).click();
        Thread.sleep(5000);
        driver.findElement(MobileBy.custom("ai:cameraauto")).click();
        driver.findElement(MobileBy.custom("ai:cameraflash")).click();
        driver.findElement(MobileBy.custom("ai:cameralock")).click();
        driver.findElement(MobileBy.custom("ai:camerasetting")).click();
        driver.navigate().back();
        Thread.sleep(5000);
        driver.quit();

    }
}
