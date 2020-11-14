package com.example.appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Calculator {
//    WebDriver driver;
    public AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", "G5 SE");
        caps.setCapability("udid", "ZH33L2Z6KL"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0.1");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset","true");
//        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Test
    public void testCal() throws Exception {
        //locate the Text on the calculator by using By.name()
        WebElement two=driver.findElement(By.id("digit_2"));
        two.click();
        WebElement plus=driver.findElement(By.id("op_add"));
        plus.click();
        WebElement four=driver.findElement(By.id("digit_4"));
        four.click();
        WebElement equalTo=driver.findElement(By.id("eq"));
        equalTo.click();
        //locate the edit box of the calculator by using By.tagName()
        WebElement results=driver.findElement(By.id("result_final"));
        //Check the calculated value on the edit box
        assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

    }

    @After
    public void teardown(){
        //close the app
        driver.quit();
    }
}