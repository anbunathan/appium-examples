import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class table {
	
	public static void main(String[] args) {
		String baseUrl = "https://www.railyatri.in/time-table";
		WebDriver driver = new FirefoxDriver();

		driver.get(baseUrl);
		String innerText = driver.findElement(
			By.xpath("//table/tbody/tr[2]/td[3]")).getText(); 	
	        System.out.println(innerText); 
		driver.quit();
		}
	}


