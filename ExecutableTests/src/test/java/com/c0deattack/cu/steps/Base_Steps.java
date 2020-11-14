package com.c0deattack.cu.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Steps {

    private WebDriver webDriver;

    public void setUp() {
        webDriver = new FirefoxDriver();
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }
}
