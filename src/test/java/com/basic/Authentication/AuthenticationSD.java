package com.basic.Authentication;


import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthenticationSD {
	String url = null; 
	String tokenURL = "https://demoqa.com/Account/v1/GenerateToken";
	String authURL = "https://demoqa.com/Account/v1/Authorized";
	String createUser = "https://demoqa.com/Account/v1/User";
	String addBookURL = "https://demoqa.com/BookStore/v1/Books";
	String addBookJsonPath= "src/test/java/com/basic/Authentication/addBook.json";
	String deleteUser = "https://demoqa.com/Account/v1/User/";
	
	Response res = null;
	Response userRes = null;
	//userIDValue = 
	
	
	@Given("^User login with username and pwd$")
	public void User_login_with_username_and_pwd() throws Throwable {
		
		//BASIC Auth
//		res = RestAssured.given()
//		.contentType("application/json; charset=UTF-8").relaxedHTTPSValidation()
//		.auth().basic("anilkale", "Welcome@123").relaxedHTTPSValidation().
//				when().get(tokenURL);
		
		//create User
		userRes = RestAssured.given().contentType("application/json; charset=UTF-8").relaxedHTTPSValidation()
				.when().body("{\"userName\":\"Test93345\",\"password\":\"Welcome@123\"}").post(createUser);
		System.out.println(" userRes Response = "+userRes.asString());
		
		System.out.println("User Response = "+userRes.asString());
		String userIDValue = userRes.body().jsonPath().getString("userID");
		System.out.println("userID= "+userIDValue);
		
		
//		//delete user
//		userRes = RestAssured.given()
//				.contentType("application/json; charset=UTF-8").relaxedHTTPSValidation()
//				.delete(deleteUser+userIDValue);
		
		
		System.out.println("========================================");
		//Get the Token
		res = RestAssured.given()
				.contentType("application/json; charset=UTF-8").relaxedHTTPSValidation()
				.when().body("{\"userName\":\"Test93345\",\"password\":\"Welcome@123\"}").post(tokenURL);
		System.out.println("Response = "+res.asString());
		String token = res.body().jsonPath().getString("token");
		System.out.println("token = "+token );
		
		//Add book with newly created user
		String data = new String(Files.readAllBytes(Paths.get(addBookJsonPath))); 
	    System.out.println("json in String ==== " +data);
		
		//Update the data
	    JSONObject object=new JSONObject(data);
	    object.put("userId", userIDValue);
	    object.put("username", "Test93345");
	    String addBookStr = object.toString();
	    System.out.println("json in after replace ==== " +addBookStr);
	    
	    //Add the book
	    Response addBookRes = RestAssured
		.given()
		.auth().basic("Test93345", "Welcome@123")
		.header("Authorization",token)
		.header("contentType","application/json; charset=UTF-8")
		.relaxedHTTPSValidation()
		.when().body(addBookStr).post(addBookURL);
	    
	    
	    
//    	//Update the data
//	    JSONObject object1=new JSONObject(data);
//	    object1.put("userId", userIDValue);
//	    object1.put("username", "Test93345");
//	    object1.put("title", "Wings of fire");
//	    String addBookStr1 = object1.toString();
//	    System.out.println("json in after replace ==== " +addBookStr1);
//	    
//	    //Add the book
//	    Response addBookRes1 = RestAssured
//		.given()
//		.auth().basic("Test93345", "Welcome@123")
//		.header("Authorization",token)
//		.header("contentType","application/json; charset=UTF-8")
//		.relaxedHTTPSValidation()
//		.when().body(addBookStr).put(addBookURL);
//	    
//	    System.out.println("Add Book Response = "+addBookRes1.asString());
		
	}


}
