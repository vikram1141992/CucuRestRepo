package com.basic.GetWithDataDriven;


import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetWithDataDrivenSD {
	String url = null; 
	Response res = null;
	
	@Given("^Get response from bookstore application$")
	public void get_response_from_bookstore_application() throws Throwable {
		url ="https://demoqa.com/BookStore/v1/Books"; 
	}

	@When("^you request for Get response$")
	public void you_request_for_Get_response() throws Throwable {
		res = RestAssured.given().relaxedHTTPSValidation().get(url);
	}

	@Then("^you check for title value$")
	public void you_check_for_title_value() throws Throwable {
		String title = res.body().jsonPath().getString("books[0].title");
		System.out.println("title = "+ title);
	}
	
	@Then("you check for title {string} at {string} value")
	public void you_check_for_title_at_value(String value, String xpath) {
	    String title = res.body().jsonPath().getString(xpath);
		System.out.println("title = "+ title);
		Assert.assertTrue(value.equals(title));
	}
	
	@Then("user checks data at path {string} having value {string} in json")
	public void user_checks_data_at_path_having_value_in_jason(String jsnpath, String value) throws Throwable {   
		String actualLiming = res.body().jsonPath().getString(jsnpath);
		Assert.assertTrue(actualLiming.equals(value));
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
