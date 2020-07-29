package com.hubspot.generic.qa.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hubspot.generic.qa.Utilities.WebEventListener;



public class BasePage {



	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;	
	public static WebEventListener eventListener;	
//	public WebDriverWait wait;
	
	{
		
			
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Bhisma\\eclipse-workspace\\hubspot_generic\\src\\main\\"
					+ "java\\com\\hubspot\\generic\\qa\\confg\\prop\\config.properties");
			prop.load(ip);
//			System.out.println(prop.getProperty("browser"));
		}
			catch(FileNotFoundException e) {
				e.printStackTrace();
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	}
		
		
		public static void initialization() {
			
 			String browserName = prop.getProperty("browser");
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","F:\\Submission Tracking\\chromedriver.exe");
				
				 driver = new ChromeDriver();
			}
			else if (browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver","//F:\\Submission Tracking\\geckodriver.exe");
				
				 driver = new FirefoxDriver();
			}

			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
		
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().(TestUtil.EXPLICIT_WAIT, TimeUnit.SECONDS);
//			driver.get(prop.getProperty("url"));
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
			
	}
	
	
	
	
}





