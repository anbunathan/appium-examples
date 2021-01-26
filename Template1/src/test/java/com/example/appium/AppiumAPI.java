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
    public static int pointAsAnInteger = 0;
    public void initializeAPIDriver(AndroidDriver andriver,
                                    String packname,
                                    String actname){
        driver = andriver;
        packageName = packname;
        activityName = actname;
        Dimension dimensions = driver.manage().window().getSize();
        Double point = dimensions.getHeight() * 0.45;
        pointAsAnInteger = point.intValue();
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

    public void clickOnListXPATH(String xpath){
//        driver.findElementByXPath("//android.widget.CheckedTextView[@index='1']").click();
        int xpath_Count = driver.findElementsByXPath(xpath).size();  //this is time consuming
        System.out.println("xpath count is : " + xpath_Count);
        if(xpath_Count == 0) {
            int counter=0;
            do {
                TouchAction action = new TouchAction(driver);
                action.press(PointOption.point(0, pointAsAnInteger * 2))
                        .moveTo(PointOption.point(0, pointAsAnInteger))
                        .release()
                        .perform();
                xpath_Count = driver.findElementsByXPath(xpath).size();
                System.out.println("xpath count is : " + xpath_Count);
                counter++;
                if(counter>100){
                    break;
                }
            } while (xpath_Count == 0);
        }
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
    }

    public void clickOnListTEXT(String text){
//        driver.findElementByXPath("//android.widget.CheckedTextView[@text='ffff:ffff:ffff:ffff:fffc:: = /78']").click();
        String classname = "//android.widget.CheckedTextView";
        boolean classnamefound = false;
        try {
            //Assumption1: classname = android.widget.CheckedTextView
            AndroidElement CTVelement = driver.findElementByClassName("android.widget.CheckedTextView");
            classnamefound = true;
        }catch(Exception e){
            System.out.println("CheckedTextView does not exist");
        }
        if(classnamefound == false)
        {
            try{
                //Assumption2: classname = android.widget.TextView
                AndroidElement TVelement = driver.findElementByClassName("android.widget.TextView");
                classnamefound = true;
                classname = "//android.widget.TextView";
            }catch(Exception e){
                System.out.println("TextView does not exist");
            }
        }

        String xpath = classname+"[@text='"+text+"']";
        int xpath_Count = driver.findElementsByXPath(xpath).size();  //this is time consuming
        System.out.println("xpath count is : " + xpath_Count);
        if(xpath_Count == 0) {
            int counter=0;
            do {
                TouchAction action = new TouchAction(driver);
                action.press(PointOption.point(0, pointAsAnInteger * 2))
                        .moveTo(PointOption.point(0, pointAsAnInteger))
                        .release()
                        .perform();
                xpath_Count = driver.findElementsByXPath(xpath).size();
                System.out.println("xpath count is : " + xpath_Count);
                counter++;
                if(counter>100){
                    break;
                }
            } while (xpath_Count == 0);
        }
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
    }

    public void clickOnListID(String id){
//        driver.findElementByXPath("//android.widget.CheckedTextView[@index='1']").click();
        String classname = "//android.widget.CheckedTextView";
        boolean classnamefound = false;
        try {
            //Assumption1: classname = android.widget.CheckedTextView
            AndroidElement CTVelement = driver.findElementByClassName("android.widget.CheckedTextView");
            classnamefound = true;
        }catch(Exception e){
            System.out.println("CheckedTextView does not exist");
        }
        if(classnamefound == false)
        {
            try{
                //Assumption2: classname = android.widget.TextView
                AndroidElement TVelement = driver.findElementByClassName("android.widget.TextView");
                classnamefound = true;
                classname = "//android.widget.TextView";
            }catch(Exception e){
                System.out.println("TextView does not exist");
            }
        }

        String xpath = classname+"[@index='"+id+"']";
//        String xpath = "//android.widget.CheckedTextView[@index='"+id+"']";
        int xpath_Count = driver.findElementsByXPath(xpath).size();  //this is time consuming
        System.out.println("xpath count is : " + xpath_Count);
        if(xpath_Count == 0) {
            int counter=0;
            do {
                TouchAction action = new TouchAction(driver);
                action.press(PointOption.point(0, pointAsAnInteger * 2))
                        .moveTo(PointOption.point(0, pointAsAnInteger))
                        .release()
                        .perform();
                xpath_Count = driver.findElementsByXPath(xpath).size();
                System.out.println("xpath count is : " + xpath_Count);
                counter++;
                if(counter>100){
                    break;
                }
            } while (xpath_Count == 0);
        }
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

    public void assertEditID(String id, String result){
        String xpath = "//android.widget.EditText[@index='"+id+"']";
        System.out.println("xpath = "+xpath);
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
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
        Thread.sleep(1000);
    }

    public void clickOnMenuTEXT(String text) throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.MENU));
        Thread.sleep(1000);
//        clickListXPATH("//android.widget.TextView[@text='Clear history']");
        String xpath = "//android.widget.TextView[@text='"+text+"']";
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
        Thread.sleep(1000);
    }

    public void clickOnMenuID(String id) throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.MENU));
        Thread.sleep(1000);
//        clickListXPATH("//android.widget.TextView[@text='Clear history']");
        String xpath = "//android.widget.TextView[@index='"+id+"']";
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
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

    public void clickLongOnEditID(String id) throws InterruptedException {
        String xpath = "//android.widget.EditText[@index='"+id+"']";
        System.out.println("xpath = "+xpath);
//        AndroidElement element = driver.findElementByXPath("//android.widget.EditText[@index='0']");
        AndroidElement element = driver.findElementByXPath(xpath);
        AndroidTouchAction touch = new AndroidTouchAction (driver);
        touch.longPress(LongPressOptions.longPressOptions()
                .withElement (ElementOption.element (element)))
                .perform ();
    }

    public void goBack(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void clickOnStringTEXT(String text) throws InterruptedException {
        String xpath = "//android.widget.TextView[@text='"+text+"']";
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
        else{
            int counter=0;
            do {
                TouchAction action = new TouchAction(driver);
                action.press(PointOption.point(0, pointAsAnInteger * 2))
                        .moveTo(PointOption.point(0, pointAsAnInteger))
                        .release()
                        .perform();
                element = driver.findElementByXPath(xpath);
                if(element.isDisplayed()){
                    element.click();
                }
                counter++;
                if(counter>100){
                    break;
                }
            } while (!element.isDisplayed());
        }

        Thread.sleep(1000);
    }

    public void clickOnStringID(String id) throws InterruptedException {
        String xpath = "//android.widget.TextView[@index='"+id+"']";
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
        Thread.sleep(1000);
    }

    public void clickOnButtonTEXT(String text) throws InterruptedException {
        String xpath = "//android.widget.Button[@text='"+text+"']";
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
        Thread.sleep(1000);
    }

    public void clickOnButtonID(String id) throws InterruptedException {
        String xpath = "//android.widget.Button[@index='"+id+"']";
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
        Thread.sleep(1000);
    }

    public void EnableCheckboxID(String id) throws InterruptedException {
        String rid = "android:id/checkbox";
        int index = Integer.valueOf(id);
        AndroidElement element = driver.findElementsById(rid).get(index);
        System.out.println("Checkbox status = "+element.getAttribute("checked"));
        if(element.getAttribute("checked").contains("false")){
            System.out.println("Enable Checkbox");
            element.click();
        }
        Thread.sleep(1000);
    }

    public void DisableCheckboxID(String id) throws InterruptedException {
        String rid = "android:id/checkbox";
        int index = Integer.valueOf(id);
        AndroidElement element = driver.findElementsById(rid).get(index);
        System.out.println("Checkbox status = "+element.getAttribute("checked"));
        if(element.getAttribute("checked").contains("true")){
            System.out.println("Disable Checkbox");
            element.click();
        }
        Thread.sleep(1000);
    }

    public void clickOnImageButtonTEXT(String text) throws InterruptedException {
        String xpath = "//android.widget.ImageButton[@text='"+text+"']";
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
        Thread.sleep(1000);
    }

    public void clickOnImageButtonID(String id) throws InterruptedException {
        String xpath = "//android.widget.ImageButton[@index='"+id+"']";
        AndroidElement element = driver.findElementByXPath(xpath);
        if(element.isDisplayed()){
            element.click();
        }
        Thread.sleep(1000);
    }
}
