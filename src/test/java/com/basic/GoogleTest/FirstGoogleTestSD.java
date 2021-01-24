package com.basic.GoogleTest;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGoogleTestSD {
	String url = null; 
	Response res = null;
	
	@Given("^you have google website link$")
	public void you_have_google_website_link(){
		url ="http://google.com/"; 
		System.out.println("Google link available");
	}
	
	@When("^you hit application url$")
	public void you_hit_application_url(){
		res = RestAssured.get(url);
		System.out.println("Hi Google URl");
	}
	
	@Then("^you check if its up and running$")
	public void youcheckifitsupandrunning(){
		System.out.println("validate response status code");
		try{
			int statCode = res.getStatusCode();
			System.out.println("Status code = "+statCode);
			System.out.println("Application Up and running");
			Assert.assertTrue(statCode==200);
		}catch(Exception e){
			System.out.println("Application not exist or down");
			Assert.assertTrue(false);
		}
	}
	
	

}
