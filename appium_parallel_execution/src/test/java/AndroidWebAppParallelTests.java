import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.net.URL;

/**
 * Created by henrrich on 2017-07-31.
 */
public class AndroidWebAppParallelTests {
    private final static String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
//    private final static String APPIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";
    private AppiumDriver driver;

    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "udid", "chromeDriverPort", "chromeDriverPath", "devicename", "serverurl"})
    public void setup(String platform, String udid, String chromeDriverPort, @Optional String chromeDriverPath,
                      String devicename, String serverurl) throws Exception {
        URL url;
        if (serverurl != null) {
            //selenium grid method
            url = new URL(serverurl);
        }
        else{
            //Appium GUI method
            url = new URL(APPIUM_SERVER_URL);
        }
        String[] platformInfo = platform.split(" ");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("chromeDriverPort", chromeDriverPort);
        if (chromeDriverPath != null) {
            capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromeDriverPath);
        }
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        driver = new AndroidDriver<MobileElement>(url, capabilities);
    }

    @Test
    public void testcase_001() throws Exception {
        driver.get("http://www.google.com");
        driver.findElementByName("q").sendKeys("appium");
        driver.getKeyboard().sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @AfterTest(alwaysRun = true)
    public void teardown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
