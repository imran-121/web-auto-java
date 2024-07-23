package com.ui.web.utilities;

import java.util.HashMap;
import java.util.Map;


import com.ui.web.pageobjects.PageObjectManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
//This is where you declare all of the general object to later on call on stepDefinitions
public class TestContext {
	
	private static final Logger LOG = LogManager.getLogger(TestContext.class);
	public WebDriver driver;
	public static Map<String, Object> session = new HashMap<String, Object>();
	public PageObjectManager pageObjectManager;
	
	
	
	public WebDriver getTcWebDriver() {
		return this.driver;
	}
	
	public WebDriver setTcWebDriver(WebDriver driver) {
		return this.driver = driver;
	}
	

	public static void storeStrContext(String Key, String value) {
		session.put(Key, value);
	}
	
	public static String fetchStrContext(String Key) {
		try {
			return (String) TestContext.session.get(Key);
		}catch(Exception e) {
			LOG.error("Got an exception", e);
			return null;
		}
		
	}
	
	
	
}
