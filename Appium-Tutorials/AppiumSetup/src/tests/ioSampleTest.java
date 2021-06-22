package tests;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL; 
public class ioSampleTest { 
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait; 
    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "G5 SE");
		caps.setCapability("udid", "LGH8451bb031b0"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.2:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    } 
    @Test
    public void basicTest () throws InterruptedException {
        //Click and pass Splash
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.android.calculator2:id/allClear"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.android.calculator2:id/digit4"))).click();        
     // Locate + by Accessibility Id locator and click on it
     	driver.findElementByAccessibilityId("Addition").click();
     	wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.android.calculator2:id/digit5"))).click();
     	WebElement equalTo = driver.findElementById("com.android.calculator2:id/equal");
		equalTo.click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}