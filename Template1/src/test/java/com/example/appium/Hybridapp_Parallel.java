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
import java.util.concurrent.TimeUnit;


public class Hybridapp_Parallel {
    private AndroidDriver<MobileElement> driver;
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

//            caps.setCapability("skipServerInstallation", "true");
//            caps.setCapability("skipDeviceInitialization", "true");
//            caps.setCapability("noReset", "true");
//            caps.setCapability("unicodeKeyboard", "true");
//            caps.setCapability("resetKeyboard", "true");
//            caps.setCapability("skipUnlock","true");

            // It will launch Chrome app in android device.
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4444/wd/hub"),caps);
            wait = new WebDriverWait(driver, 300);
            actualTest(driver);
            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualTest(AndroidDriver driver) throws InterruptedException {
        //create By object for Webview - android.webkit.WebView
        By webView = By.className("android.webkit.WebView");
        //1. Native app part
        //By Id
        //Locate "go website" using its ID and click
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.snc.test.webview2:id/action_go_website"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.snc.test.webview2:id/input_url")));
        WebElement inputurl = driver.findElement(By.id("com.snc.test.webview2:id/input_url"));
        inputurl.clear();
        inputurl.sendKeys("www.google.com");
        //Locate Move button using its name and click
        WebElement movebutton = driver.findElementById("android:id/button1");
        movebutton.click();
        Thread.sleep(25000);
        //Context switch to Webview
        //Create wait object for Webdriver wait
        WebDriverWait wait = new WebDriverWait(driver,300);
        // Wait till Webview element appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(webView));
        // Call getContext() method to return contexts like 'NATIVE_APP' or 'WEBVIEW_1'
        Set<String> availableContexts = driver.getContextHandles();
        System.out.println("Total No of Context  = "+ availableContexts.size());
        //Loop through contexts and select Webview
        for(String context : availableContexts) {
            System.out.println("Context Name is " + context);
            if(context.contains("WEBVIEW_com")){
                System.out.println("Context Name with WEBVIEW is " + context);
                driver.context(context);
            }
        }
        driver.findElementByXPath("//input[@name=\"q\"]").sendKeys("India");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

    }
}