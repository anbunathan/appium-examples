package com.example.appium;
import org.openqa.selenium.remote.CapabilityType;
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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HybridApp {
    //create Android driver object
    public static AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;
    @Test
    @Parameters("runOn")
    public static void test(@Optional("ZH33L2Z6KL") String runOn) throws MalformedURLException, InterruptedException {
        //create By object for Webview - android.webkit.WebView
        By webView = By.className("android.webkit.WebView");
        //create Android driver object
        //Initialize the test
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (runOn.contains("ZH33L2Z6KL")) {
            capabilities.setCapability("udid", "ZH33L2Z6KL");
            capabilities.setCapability("deviceName", "Moto G");
            capabilities.setCapability("systemPort", "8201");
            // Set android platformName desired capability. It's Android in our case here.
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "7.1.1");

        } else if (runOn.contains("fca3752eeaac")) {
            capabilities.setCapability("udid", "fca3752eeaac");
            capabilities.setCapability("deviceName", "MI A3");
            capabilities.setCapability("systemPort", "8202");
            // Set android platformName desired capability. It's Android in our case here.
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "10");
        }
        capabilities.setCapability("automationName", "uiautomator2");
        // Set app path
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("chromedriverExecutable","C:\\chromedriver\\chromedriver.exe");
        capabilities.setCapability("app","D:\\workshop\\Appium\\backup\\WebView-Test.apk");
        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        capabilities.setCapability("skipUnlock","true");
        capabilities.setCapability("autoGrantPermissions","true");
        capabilities.setCapability("noReset","false");
        // It will launch Chrome app in android device.
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 300);
        //1. Native app part
        //By Id
        //Locate "go website" using its ID and click
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.snc.test.webview2:id/action_go_website"))).click();
        //Allow app permissions
        allowAppPermission();
        //Locate "input URL" field using its ID and type "www.facebook.com"
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.snc.test.webview2:id/input_url")));
        WebElement inputurl = driver.findElement(By.id("com.snc.test.webview2:id/input_url"));
        inputurl.clear();
        inputurl.sendKeys("m.facebook.com");
        //Locate Move button using its name and click
        WebElement movebutton = driver.findElementById("android:id/button1");
        movebutton.click();
        Thread.sleep(5000);
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
            if(context.contains("WEBVIEW")){
                System.out.println("Context Name is " + context);
//                break;
            }
        }
        System.out.println(driver.getPageSource());
        //2. Webapp part
        //By Id
        //Locate Email and Password fields using their Ids
        Thread.sleep(5000);
        WebElement email = driver.findElementById("com.snc.test.webview2:id/m_login_email");
//        WebElement email = driver.findElementById("m_login_email");
        email.clear();
        email.sendKeys("test@gmail.com");
        //By name
        //Locate Log In button using its name and click
        WebElement loginbutton = driver.findElementByName("com.snc.test.webview2:name/login");
        loginbutton.click();
        WebElement password = driver.findElementById("com.snc.test.webview2:id/m_login_password");
        password.clear();
        password.sendKeys("test123");
        //By name
        //Locate Log In button using its name and Log In
        loginbutton = driver.findElementByName("com.snc.test.webview2:name/login");
        loginbutton.click();
        Thread.sleep(15000);
        //By XPath
        //Locate Error message using XPath and get the message using 'getText' method
        //WebElement errormessage = driver.findElementByXPath("//*[@class='_52jd']/span");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@id='root']//span")));
        WebElement errormessage = driver.findElementByXPath("//div[@id='root']//span");
        String message = errormessage.getText();
        System.out.println("Error message = "+message);
        //Assert Error message
        Assert.assertEquals(
                "The password you entered is incorrect. Did you forget your password?", message);
    }

    public static void allowAppPermission() {
        try{
            //In a loop, check for window with 2 buttons and one button is having name as "Allow"
            while (driver.findElementsByXPath("//*[@class='android.widget.Button'][2]").size() > 0 &&
                    driver.findElementById("com.android.packageinstaller:id/permission_allow_button")
                            .getText().contains("ALLOW"))
//                             .getText().contains("Allow"))
            {
                //Click allow button
                //com.android.packageinstaller:id/permission_allow_button
                driver.findElementByXPath("//*[@class='android.widget.Button'][2]").click();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
