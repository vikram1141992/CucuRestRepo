package com.basic.GetAndValidateHeaders;


import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetAndValidateHeadersSD {
	String url = null; 
	Response res = null;
	
	@Given("^Get response from bookstore application$")
	public void get_response_from_bookstore_application() throws Throwable {
		url ="https://demoqa.com/BookStore/v1/Books"; 
	}

	@When("^you request for Get response$")
	public void you_request_for_Get_response() throws Throwable {
		res = RestAssured.given()
				.header("Content-Type","application/json; charset=utf-8")
				.relaxedHTTPSValidation().get(url);
	}

	@Then("^You checks all headers of response$")
	public void You_checks_all_headers_of_response() throws Throwable {
		Headers heds = res.getHeaders();
		//1
		String actualHeaderValue = heds.getValue("Content-Type");
		Assert.assertTrue(actualHeaderValue.equals("application/json; charset=utf-8"));
		
		//2
		String actualHeaderValue1 = heds.getValue("connection");
		Assert.assertTrue(actualHeaderValue1.equals("keep-alive"));

	}
	
	



}
