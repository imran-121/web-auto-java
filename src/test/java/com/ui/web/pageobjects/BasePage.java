package com.ui.web.pageobjects;


import org.openqa.selenium.WebDriver;


public class BasePage {
	
	WebDriver driver;
	
	BasePage(){
		
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	
}
   
