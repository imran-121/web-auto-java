package com.ui.web.pageobjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;



import com.ui.web.utilities.DriverSetup;


public class PageObjectManager {
	
	public static final Logger LOG = LogManager.getLogger(PageObjectManager.class);
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static CartPage cartPage;

    public static void  initWebDriver() {
    	try {
    		PageObjectManager.driver = new DriverSetup().setupNewDriver();
    	}
    	catch(Exception e) {
			PageObjectManager.LOG.error("Got an exception", e);
		}
	}

    public static LoginPage getLoginPage() {
    	try {
    		loginPage = new LoginPage(PageObjectManager.driver);
            return loginPage;
    	}catch(Exception e) {
			PageObjectManager.LOG.error("Got an exception", e);
			return null;
		}
    }
    
    
    public static CartPage getCartPage() {
    	try {
    		cartPage = new CartPage(PageObjectManager.driver);
            return cartPage;
    	}catch(Exception e) {
			PageObjectManager.LOG.error("Got an exception", e);
			return null;
		}
    }
    

    public static void  closeWebDriver() {
		PageObjectManager.driver.quit();
	}

}