package com.example.appium;


import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
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


public class HybridApp2 {
    //create Android driver object
    public static AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;
    @Test
    public void testWebview_Android() throws MalformedURLException, InterruptedException {

        //create Android driver object

        //Initialize the test
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("udid", "ZH33L2Z6KL");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("skipServerInstallation", "true");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("skipDeviceInitialization", "true");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("app","D:\\Webapp\\app\\WebView-Test.apk");
        capabilities.setCapability("skipUnlock","true");
        capabilities.setCapability("chromedriverExecutable", "C:\\Program Files\\Appium\\resources\\app"
                + "\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
        // It will launch Chrome app in android device.
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        wait = new WebDriverWait(driver, 300);
        actualTest(driver);

    }

    public void actualTest(AndroidDriver driver) throws InterruptedException {
        //create By object for Webview - android.webkit.WebView
        By webView = By.className("android.webkit.WebView");
        //1. Native app part
        //By Id
        //Locate "go website" using its ID and click
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.snc.test.webview2:id/action_go_website"))).click();
        //driver.findElement(By.id("com.snc.test.webview2:id/action_go_website")).click();
        //Allow app permissions
//        allowAppPermission();
        //Locate "input URL" field using its ID and type "www.facebook.com"
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
                // Call context() method and change it to WEBVIEW_1
                //(This puts Appium session into the web view)
                driver.context(context);
//                break;
            }
        }

//        Thread.sleep(6000);
//        driver.findElementByClassName("android.widget.EditText").sendKeys("India");
//        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
//        driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"webview\"]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.Button[1]").click();

        driver.findElementByXPath("//input[@name=\"q\"]").sendKeys("India");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

    }

    public static void allowAppPermission() {
        try{
            //In a loop, check for window with 2 buttons and one button is having name as "Allow"
            while (driver.findElementsByXPath("//*[@class='android.widget.Button'][2]").size() > 0 &&
                    driver.findElementById("com.android.packageinstaller:id/permission_allow_button")
                            .getText().contains("Allow"))
            {
                //Click allow button
                driver.findElementByXPath("//*[@class='android.widget.Button'][2]").click();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
