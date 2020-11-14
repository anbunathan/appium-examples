package com.example.appium;

import org.junit.runner.JUnitCore;
import java.net.MalformedURLException;
public class Runner {
    public static void main(String[] args) throws MalformedURLException {
        try{
            JUnitCore.runClasses(com.example.appium.Calculator.class);
        }finally {
        }
    }
}
