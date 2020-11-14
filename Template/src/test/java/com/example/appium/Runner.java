package com.example.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import com.example.appium.MyLogger;

public class Runner {
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

    public void startServer() {
        //Set Capabilities
        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public void stopServer() {
        service.stop();
    }

    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void main(String[] args) throws MalformedURLException {
        Runner runner = new Runner();
        int port = 4723;
        if(!runner.checkIfServerIsRunnning(port)) {
            runner.startServer();
            System.out.println("Started");
            try {
                Thread.sleep(3000);
                JUnitCore.runClasses(com.example.appium.Calculator.class);
                MyLogger.log.info("Test result = PASS");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                MyLogger.log.info("Test result = FAIL");
            }
            runner.stopServer();
            System.out.println("Stopped");
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }
        try{
//            JUnitCore.runClasses(com.example.appium.Calculator.class);
        }finally {
        }
    }
}
