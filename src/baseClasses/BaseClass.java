package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	@Parameters("browser")
	public static WebDriver getWebDriver(String a) 
	{
	   
	   if(a.equals("chrome"))
	   {
	        System.setProperty("webdriver.chrome.driver", "F:\\Pandit\\Required Document\\Selenium\\chromedriver.exe");
	    	
	    	
			WebDriver driver = new ChromeDriver();      //upcasting
			
			driver.get("https://www.flipkart.com/"); //get.(string url):void-webdriverpackage selenium;

			
			driver.manage().window().maximize();      //for maximize the method
			
			return driver;
	   }
	   else if(a.equals("firefox"))
	   {
		   System.setProperty("webdriver.gecko.driver", "F:\\Pandit\\Required Document\\Selenium\\Firefox\\geckodriver.exe"); // Setting system properties of FirefoxDriver
			
		    WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
				
				driver.get("https://www.flipkart.com/"); //get.(string url):void-webdriverpackage selenium;

				
				driver.manage().window().maximize();      //for maximize the method
				
				return driver;   
	   }
	   else
	   {
		   System.setProperty("webdriver.ie.driver", "F:\\Pandit\\Required Document\\Selenium\\IE\\IEDriverServer.exe"); // Setting system properties of FirefoxDriver
			
		   WebDriver driver=new InternetExplorerDriver(); // Instantiate a IEDriver class. 
				
				driver.get("https://www.flipkart.com/"); //get.(string url):void-webdriverpackage selenium;

				
				driver.manage().window().maximize();      //for maximize the method
				
				return driver;  
		   
	   }
	
    }

}
