package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

	public static WebDriver driver;

    public static void initializeWebDriver() throws IOException {  
		
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
	
	     
        // To maximize browser  
       driver.manage().window().maximize();  
    
        // Implicit wait  
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://docs.thebootcampplatform.com/add-doc"); 
	
	}
	
	
	 public static void quitDriver() {  
         driver.quit();  
    }
	
}
