package com.example.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class CalculatorCLI {
    private AndroidDriver<MobileElement> driver;
    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "7.1.1");
        capabilities.setCapability("deviceName","Moto G");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("udid", "ZH33L2Z6KL");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("skipServerInstallation", "true");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @Test
    public void testCal() throws Exception {
        driver.findElementById("digit_2").click();
        driver.findElementById("op_add").click();
        driver.findElementById("digit_4").click();
        driver.findElementById("eq").click();
        WebElement results=driver.findElementById("result_final");
        assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";
        driver.quit();
        System.out.println("Test1 Exceution Ended");
    }

    @AfterClass
    public void teardown(){
        //close the app
        driver.quit();
    }
}
