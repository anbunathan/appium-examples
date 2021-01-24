package com.example.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumAPI {
    public static AndroidDriver<AndroidElement> driver;
    public static String packageName = null;
    public static String activityName = null;
    public void initializeAPIDriver(AndroidDriver andriver,
                                    String packname,
                                    String actname){
        driver = andriver;
        packageName = packname;
        activityName = actname;
    }
    public void clickListItem( String item){
        String xpath = "//android.widget.CheckedTextView[@text='"+ item + "']";
        System.out.println("xpath = "+xpath);
//        driver.findElementByXPath("//android.widget.CheckedTextView[@text='Kilograms']").click();
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
    }

    public void clickListXPATH(String xpath){
//        String xpath = "//android.widget.CheckedTextView[@index='"+ id + "']";
//        System.out.println("xpath = "+xpath);
//        driver.findElementByXPath("//android.widget.CheckedTextView[@index='1']").click();
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
    }

    public void clickOnElementRID(String rid){
        String resourceID = packageName+":id/"+rid;
        System.out.println("resourceID = "+resourceID);
//        driver.findElementById("com.zola.bmi:id/weightSpinner").click();
        AndroidElement element = driver.findElementById(resourceID);
        if(element.isDisplayed()){
            element.click();
        }
    }

    public void enterTextRID(String rid, String input){
        String resourceID = packageName+":id/"+rid;
        System.out.println("resourceID = "+resourceID);
//        driver.findElementById("com.zola.bmi:id/weightNum").sendKeys("90");
        AndroidElement element = driver.findElementById(resourceID);
        if(element.isDisplayed()){
            element.sendKeys(input);
        }
    }

    public void assertTrueRID(String rid, String result){
        String resourceID = packageName+":id/"+rid;
        System.out.println("resourceID = "+resourceID);
//        assert driver.findElementById("com.zola.bmi:id/resultLabel").getText().contains("Obese");
        AndroidElement element = driver.findElementById(resourceID);
        if(element.isDisplayed()){
            element.getText().contains(result);
        }
    }

    public void assertTrueXPATH(String xpath, String result){
//        String xpath = "//android.widget.EditText[@index='0']";
//        System.out.println("xpath = "+xpath);
//        AndroidElement element = driver.findElementByXPath("//android.widget.EditText[@index='0']");
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.getText().contains(result);
        }
    }

    public void clickOnMenuXPATH(String xpath) throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.MENU));
        Thread.sleep(1000);
//        clickListXPATH("//android.widget.TextView[@text='Clear history']");
        clickListXPATH(xpath);
        Thread.sleep(1000);
    }

    public void clickLongOnElementXPATH(String xpath) throws InterruptedException {
//        AndroidElement element = driver.findElementByXPath("//android.widget.EditText[@index='0']");
        AndroidElement element = driver.findElementByXPath(xpath);
        AndroidTouchAction touch = new AndroidTouchAction (driver);
        touch.longPress(LongPressOptions.longPressOptions()
                .withElement (ElementOption.element (element)))
                .perform ();
    }
}
