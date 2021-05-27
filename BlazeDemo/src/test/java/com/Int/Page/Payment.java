package com.Int.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Payment extends MainPage{
	
	public Payment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 By name = By.cssSelector("#inputName");
	  By address  = By.cssSelector("#address");
	  By city  = By.cssSelector("#city");
	  By state  = By.cssSelector("#state");
	  By zipCode  = By.cssSelector("#zipCode");
	  By cardType  = By.cssSelector("#cardType");
	  By ccNum = By.cssSelector("#creditCardNumber");
	  By month = By.cssSelector("#creditCardMonth");
	  By year = By.cssSelector("#creditCardYear");
	  By nameOncard = By.cssSelector("#nameOnCard");
	  
	  By purchaseFlightBtn = By.cssSelector("[value='Purchase Flight']");
	  public static By confirmID = By.cssSelector("table tbody tr:nth-child(1) td:nth-child(2)");
	  public static By sucessHeader = By.cssSelector(".hero-unit h1");
	  
	  public void addPaxInfo() throws InterruptedException{
			 driver.findElement(name).sendKeys("Tester Test");
			 driver.findElement(address).sendKeys("Tester Street");
			 driver.findElement(city).sendKeys("Bangalore");
			 driver.findElement(state).sendKeys("Karnataka");
			 driver.findElement(zipCode).sendKeys("356466");		 
			
			 
		}  
	
	public void addPayment() throws InterruptedException{
		  addPaxInfo();
		  creditCardPayment();
		 
	}
	
	public void creditCardPayment() throws InterruptedException{
		 Select cardSel = new Select(driver.findElement(cardType));
		 cardSel.selectByValue("amex");		 
		 driver.findElement(ccNum).clear();
		 driver.findElement(ccNum).sendKeys("4444333322221111");
		 driver.findElement(month).clear();
		 driver.findElement(month).sendKeys("12");
		 driver.findElement(year).clear();
		 driver.findElement(year).sendKeys("2023");
		 driver.findElement(nameOncard).sendKeys("Tester");		 
		  Thread.sleep(5000);
		 
	}
	
	public void clickPurchaseBtn(){
		//To Click on Proceed to Payment Button -
		 driver.findElement(purchaseFlightBtn).click();
	}
	
}
