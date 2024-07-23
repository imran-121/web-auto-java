package com.ui.web.pageobjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CartPage extends BasePage{
	
	private static final Logger LOG = LogManager.getLogger(CartPage.class);
	
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    
    public static String textxtt;
    
    @FindBy(id="add-to-cart")
    WebElement addToCartBtn;
   
    @FindBy(xpath="//a/span[@class='shopping_cart_badge']")
    WebElement shoppingCartBadge;

    private WebElement getSelectedItemWebElement(String itemName) {
    	itemName = "//*[text()='XXXX']".replace("XXXX", "Sauce Labs Backpack");
    	return this.driver.findElement(By.xpath(itemName));
    }
    
    
    public void clickOnSelectedItem(String itemName) {
    	try {
    		this.getSelectedItemWebElement(itemName).click();
    	}catch(Exception e) {
     			LOG.error("Got an exception", e);
    	}
    	
    }
    
    public void clickAddToCart() {
    	try {
    		addToCartBtn.click();
    	}catch(Exception e) {
 			LOG.error("Got an exception", e);
    	}
    }
    
    public String getShoppingCartBadgeValue() {
    	try {
    		return shoppingCartBadge.getText();
    	}catch(Exception e) {
 			LOG.error("Got an exception", e);
 			return null;
    	}
    	
    }
    
 
  
}
