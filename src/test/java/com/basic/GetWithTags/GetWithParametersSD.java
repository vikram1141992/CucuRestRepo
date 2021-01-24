package com.basic.GetWithTags;


import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetWithParametersSD {
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
		Assert.assertTrue(title.equals("Git Pocket Guide"));
	}
	
	@Then("you check for title {string} at {string} value")
	public void you_check_for_title_at_value(String value, String xpath) {
	    String title = res.body().jsonPath().getString(xpath);
		Assert.assertTrue(value.equals(title));
	}



}
