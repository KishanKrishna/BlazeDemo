package com.Int.Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Int.Page.ChooseFlight;
import com.Int.Page.FlightSearch;
import com.Int.Page.Payment;

/**
 * Test case Type : Negative Test case - Booking with out Payment
 * @author Kishan
 *
 */

public class BookWithOutPayment {
	
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
		  page.search("Boston","London");
		  
		  
		  //Step 2 : Choose Flight 	  
		  ChooseFlight choseFlight = new ChooseFlight(webDriver);
		  choseFlight.selectFlight(1);		
		  Thread.sleep(3000);
		  
		  //Step 4 : Enter Pax and Pay Info
		  Payment pay = new Payment(webDriver);
		  pay.addPaxInfo();
		  pay.clickPurchaseBtn();
			 
		 
		 String confirmationID = webDriver.findElement(Payment.confirmID).getText();
		 if(confirmationID.isEmpty()){	
			 Assert.assertTrue(true, "Confirmation ID is empty");
		 }else{
			 Assert.assertFalse(false, "Confirmation ID is appearing");
		 }
		 Thread.sleep(3000);
			 
		 webDriver.close();
		 webDriver.quit();
		 

	}
	

}
