package com.ui.web.datamodels;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Credential extends  ModelBase{
	
	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("password")
	private String password;
	
	
	public Credential() {
		
	}
	
	public Credential(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	

	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUserName(String userName) {
		 this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static Credential mapStringToCredentialObject(String string) {
    	try {
			return new ObjectMapper().readValue(string , Credential.class);
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}
