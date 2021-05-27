package com.Int.Page;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ChooseFlight extends MainPage{
	
	public ChooseFlight(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By price = By.cssSelector("table tbody tr td:nth-child(7)");
	MessageFormat chooseFlightBtn = new MessageFormat("table tbody tr:nth-child({0}) td input");
	
	public int getCheapFlightNum() throws InterruptedException{
		 List<WebElement> priceLst = driver.findElements(price);
		  int flightOption = 1;
		  float minAmt = 0;
		  for (int i = 1; i< priceLst.size();i++){
			  WebElement each = priceLst.get(i-1);
			  WebElement nextEach = priceLst.get(i);
			  float amt = Float.parseFloat(each.getText().replace("$", ""));
			  float nextAmt = Float.parseFloat(nextEach.getText().replace("$", ""));
			  
			  if(amt<nextAmt){
				  minAmt = amt;
				  flightOption = i;
			  }
		  }
		  System.out.println(minAmt);
		  System.out.println(flightOption);
		  return flightOption;
	}
	
	public void selectCheapFlight() throws InterruptedException{	
		  int flightNum = getCheapFlightNum();
		  Object[] numOpt = {flightNum};
		  System.out.println(By.cssSelector(chooseFlightBtn.format(numOpt)));
		  By fltBtn = By.cssSelector(chooseFlightBtn.format(numOpt));
		  System.out.println(fltBtn);
		  driver.findElement(fltBtn).click();
	}
	
	public void selectFlight(int flightNum){		 
		  Object[] numOpt = {flightNum};
		  System.out.println(By.cssSelector(chooseFlightBtn.format(numOpt)));
		  By fltBtn = By.cssSelector(chooseFlightBtn.format(numOpt));
		  System.out.println(fltBtn);
		  driver.findElement(fltBtn).click();
	}
	 
}
