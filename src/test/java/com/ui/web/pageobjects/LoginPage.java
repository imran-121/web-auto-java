package com.ui.web.pageobjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ui.web.datamodels.Credential;
import com.ui.web.utilities.Readers;
import com.ui.web.pageobjects.BasePage;



public class LoginPage extends BasePage{
	
	private static final Logger LOG = LogManager.getLogger(LoginPage.class);
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //WebElements
    @FindBy(id = "user-name")
    WebElement usernameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;

    public void inputTextOnUsername(String username) {
    	try {
    		usernameInput.sendKeys(username);
    	}catch(Exception e) {
 			LOG.error("Got an exception", e);
 		}
    }

    public void inputTextOnPassword(String password) {
    	try {
    		passwordInput.sendKeys(password);
    	}catch(Exception e) {
 			LOG.error("Got an exception", e);
 		}
        
    }

    public void clickLoginButton() {
    	try {
    		loginButton.click();
    	}catch(Exception e) {
 			LOG.error("Got an exception", e);
 		}
        
        
    }
    
 // ReadCredFromJSONINPUT
 	public static Credential getCredObjFromJsonFile(String jsonFileName, String user_category) {
 		try {
 			String data = Readers.JsonReader.readJsonData(jsonFileName, user_category);
 	 		return Credential.mapStringToCredentialObject(data) ;
 		}catch(Exception e) {
 			LOG.error("Got an exception", e);
 			return null;
 		}
 		
 	}
 	
 	
 	public void enterCredsAndClickLoginBtn(Credential cred) {
 		try {
 			this.inputTextOnUsername(cred.getUserName());
 			this.inputTextOnPassword(cred.getPassword());
 			this.clickLoginButton();
 			
 		}catch(Exception e) {
 			LOG.error("Got an exception", e);
 		
 		}
 		
 	}
}
