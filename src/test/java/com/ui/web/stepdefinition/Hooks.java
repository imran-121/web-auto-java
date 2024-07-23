package com.ui.web.stepdefinition;



import com.ui.web.pageobjects.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;


public class Hooks extends PageObjectManager{

	
	
	@Before
	public void setup() {
		try {
			PageObjectManager.initWebDriver();
		}catch(Exception e) {
			PageObjectManager.LOG.error("Got an exception", e);
		}
	
	}
	
	@After
	public void tearDown(Scenario scenario) {
		try {
			PageObjectManager.closeWebDriver();
		}catch(Exception e) {
			PageObjectManager.LOG.error("Got an exception", e);
		}
		
	}

	 @BeforeAll 
	 public static void beforeAll() { 
		 // Runs before all scenarios
	 System.out.println("********************************************************************"); 
	 System.out.println("********************* EXECUTION STARTED ****************************");
	 System.out.println("********************************************************************"); 
	 }
	 
	 
	 @AfterAll 
	 public static void afterAll() { 
		 // For Post feature execution
	 System.out.println("********************************************************************"); 
	 System.out.println("********************* EXECUTION ENDED ******************************");
	 System.out.println("********************************************************************"); 
	 // 
	 }
	 
	
	
}
