package com.Int.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightSearch extends MainPage{
	
	public FlightSearch(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 By fromLoc = By.cssSelector("select[name='fromPort']");
	 By toLoc = By.cssSelector("select[name='toPort']");
	 By findFlightsBtn = By.cssSelector("input[value='Find Flights']");
	
	public void search(String expectedFrom,String expectedTo) throws InterruptedException{
		Select selFromLoc = new Select(driver.findElement(fromLoc));
		  selFromLoc.selectByValue(expectedFrom);		  
		  Select selTOLoc = new Select(driver.findElement(toLoc));
		  selTOLoc.selectByValue(expectedTo);		  
		  Thread.sleep(3000);		  
		  //Step 2 : Click on Find Flights Button
		  driver.findElement(findFlightsBtn).click();
		  Thread.sleep(3000);
	}
	
}
