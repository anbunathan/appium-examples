package com.example.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BMI {
    private AndroidDriver<MobileElement> driver;
    AppiumAPI api = new AppiumAPI();
    String packageName = "com.zola.bmi";
    String activityName = "com.zola.bmi.BMIMain";
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
            caps.setCapability("appPackage", packageName);
            caps.setCapability("appActivity", activityName);
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4444/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            api.initializeAPIDriver(driver, packageName, activityName);
            Thread.sleep(5000);
//            driver.findElementById("com.zola.bmi:id/weightSpinner").click();
            api.clickOnElementRID("weightSpinner");
            api.clickOnListID("1");
//            api.clickListItem("Kilograms");
//            driver.findElementById("com.zola.bmi:id/heightSpinner").click();
            api.clickOnElementRID("heightSpinner");
            api.clickOnListID("1");
//            driver.navigate().back();
//            driver.findElementById("com.zola.bmi:id/weightNum").sendKeys("90");
//            driver.findElementById("com.zola.bmi:id/heightNum").sendKeys("60");
//            driver.findElementById("com.zola.bmi:id/calcBMI").click();
            api.enterTextRID("weightNum", "90");
            api.enterTextRID("heightNum", "60");
            api.clickOnElementRID("calcBMI");
//            WebElement results=driver.findElementById("com.zola.bmi:id/resultLabel");
//            assert results.getText().contains("Obese"):"Actual value is : "+results.getText()+" did not match with expected value: Obese";
//            assert driver.findElementById("com.zola.bmi:id/resultLabel").getText().contains("Obese");
            api.assertTrueRID("resultLabel", "Obese");
            driver.quit();
            System.out.println("Test1 Exceution Ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}