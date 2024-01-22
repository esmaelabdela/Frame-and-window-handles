package variousConcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnIframe {

	WebDriver driver;

	// Store WebElemenet BY CLASS
	By USERNAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@id='login_submit']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//span[contains(text() ,'Dashboard')]");
	

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest3() {
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
	
        String title1 = driver.getTitle();
        System.out.println(title1);
        String handle1 =  driver.getWindowHandle();
        System.out.println(handle1);
        
		driver.switchTo().frame("advertisement");
	    driver.findElement(By.xpath("//*[@id=\"ad_three\"]/a/img")).click();
		
	        Set<String> handles = driver.getWindowHandles();
		    System.out.println(handles);
		    
	       for(String i : handles) {
    	   driver.switchTo().window(i);
	         }
		   
	        String title2 = driver.getTitle();
	        System.out.println(title2);
	        
	        driver.switchTo().window(handle1);
	        driver.switchTo().frame("advertisement");
	        driver.findElement(By.xpath("//*[@id=\"ad_two\"]/a/img")) .click();
			    
	        
	        Set<String> handles1 = driver.getWindowHandles();
		    System.out.println(handles1);
		    
	       for(String i : handles1) {
	    //	   System.out.println(i);  
	    	   driver.switchTo().window(i);
	         }
		   
	        String title3 = driver.getTitle();
	        System.out.println(title3);

	        
	        
	        
	        
		}	
		
		

 	
}
