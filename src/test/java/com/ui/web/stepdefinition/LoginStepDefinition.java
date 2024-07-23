package com.ui.web.stepdefinition;


import io.cucumber.java.ParameterType;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import com.ui.web.pageobjects.PageObjectManager;
import com.ui.web.pageobjects.LoginPage;
import com.ui.web.utilities.TestContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.ui.web.utilities.Constants;

public class LoginStepDefinition extends TestContext {

	 
    public LoginPage loginPage;

    public LoginStepDefinition() {
    	
    	this.loginPage = PageObjectManager.getLoginPage();
    }
    

    
    
    @ParameterType(".*")
    public Boolean booleanValue(String value) {
    	value = value.replace("\"", ""); // got an issue in cucumber string parsing
    	return Boolean.valueOf(value);
    }
    
 
    

    @Given("user has credentials {string} from {string}")
    public void userHasCredentials(String user_category, String jsonFileName) {

    	String userName = LoginPage.getCredObjFromJsonFile(jsonFileName, user_category).getUserName();
    	String password = LoginPage.getCredObjFromJsonFile(jsonFileName, user_category).getPassword();

    	storeStrContext("username", userName);
    	storeStrContext("password", password);
    }
    
    

    @When("user enters name and password")
    public void userEntersCredentials() {
    	loginPage.inputTextOnUsername(fetchStrContext("username"));
    	loginPage.inputTextOnPassword(fetchStrContext("password"));
    }
    
    
    @When("user clicks to submit button")
    public void clickSubmitButton() {
    	loginPage.clickLoginButton();
    }
    
    
    
    @Then("user should be {booleanValue} see the dashboard page")
    public void accessToDashBoard(Boolean accessFlag) {
    	
    	if(accessFlag) {
    		assertEquals(Constants.Urls.INVENTORY,loginPage.getCurrentUrl());
    	}else {
    		assertNotEquals(Constants.Urls.INVENTORY,loginPage.getCurrentUrl());
    	}
    	
    }
}
