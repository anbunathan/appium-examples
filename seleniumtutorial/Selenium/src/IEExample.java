import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class IEExample {


    public static void main(String[] args) throws InterruptedException {
         	
    	//WebDriver driver = new EdgeDriver();
    	WebDriver driver = new InternetExplorerDriver();
    	
        String baseUrl = "http://demo.guru99.com/test/link.html";
        String expectedTitle = "WebDriver";
        String actualTitle = "";
        
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        WebDriverWait wait=new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
        //driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS) ;
        //Thread.sleep(3);
        // get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println("actualTitle = "+actualTitle);
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        //close Fire fox
        driver.close();
       
    }

}