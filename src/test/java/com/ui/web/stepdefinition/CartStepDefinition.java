package com.ui.web.stepdefinition;

import static org.junit.Assert.assertEquals;


import com.ui.web.datamodels.Credential;
import com.ui.web.pageobjects.CartPage;
import com.ui.web.pageobjects.LoginPage;
import com.ui.web.pageobjects.PageObjectManager;

import com.ui.web.utilities.Readers;
import com.ui.web.utilities.Readers.DataTableReader;
import com.ui.web.utilities.TestContext;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefinition extends TestContext{
	
		public LoginPage loginPage;
		public CartPage cartPage;
	 

	    public CartStepDefinition() {
	    	this.loginPage = PageObjectManager.getLoginPage();
	    	this.cartPage = PageObjectManager.getCartPage();
	    }
	    

	    @Given("user is logged in using below credentials")
	    public void userIsLoggedIn(DataTable dataTable) {
	    	
	    	Readers.DataTableReader.readDataTableToLstMap(dataTable);
	    	
	    	String userCategory = DataTableReader.getFirstRowDataTable("user_category");
	    	String inputJson = DataTableReader.getFirstRowDataTable("input_json");

	    	Credential cred = LoginPage.getCredObjFromJsonFile(inputJson, userCategory);
	    	
	    	this.loginPage.enterCredsAndClickLoginBtn(cred);
	    

	    }
	    
	    

	    @Given("user clicks on {string}")
	    public void userEntersCredentials(String item) {

	 	    this.cartPage.clickOnSelectedItem(item);
	 	    
	    }
	    
	    
	    @When("user cliks on add to cart button")
	    public void clickAddtoCart() {
	    	this.cartPage.clickAddToCart();
	    }
	    
	    
	    
	    @Then("user should be able to see item in cart {string}")
	    public void checkItemAdded(String expItemCount) {
	    	
	    	//this.cartPage.getShoppingCartBadgeValue();
	    	//System.out.println(this.cartPage.getShoppingCartBadgeValue());
	    	assertEquals(expItemCount, this.cartPage.getShoppingCartBadgeValue());
	    }
}
