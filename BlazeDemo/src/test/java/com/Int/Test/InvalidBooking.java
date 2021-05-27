package com.Int.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.Int.Page.FlightSearch;



/**
 * Test case Type : Negative Test case - Invalid Route Booking 
 * @author Kishan
 *
 */
public class InvalidBooking {
	
	@Test
	public void scenario() throws InterruptedException{
		  String url = "https://blazedemo.com";
		  String browser = "chrome";
		  String CHROMEPATH = "D:\\Interview_Setup\\chromedriver.exe";
		  WebDriver webDriver=null;
		  switch(browser){
			  case "chrome" :
				  System.out.println("Chrome browser Execution");
				  System.setProperty("webdriver.chrome.driver", CHROMEPATH);
				  webDriver = new ChromeDriver();
				  break;
			  case "firefox" :
				  webDriver = new FirefoxDriver();
				  break;
			 default:
				 System.setProperty("webdriver.chrome.driver", CHROMEPATH);
				 webDriver = new ChromeDriver(); 
		  }
		  
		  
		  webDriver.get(url);
		  webDriver.manage().window().maximize();
		 // Step 1 : Select From and Select To and Click On Find Flights Button		
		  FlightSearch page = new FlightSearch(webDriver);
		  try{
			  page.search("Hyderabad","London");
		  }catch(Exception e){
			  System.out.println("Invalid Search check is working");
		  }
		  
		
			 
		 webDriver.close();
		 webDriver.quit();
		 

	}
	

}
