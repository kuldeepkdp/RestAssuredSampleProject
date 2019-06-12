package com.kdp.apiTestingRestAssured.stepDefination;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.response.Response;

import com.kdp.apiTestingRestAssured.base.Base;

import cucumber.api.java.en.Given;
import com.kdp.apiTestingRestAssured.base.Base;
import java.time.LocalDate;
import java.time.LocalTime;

public class PostingTweetsSteps {
	
	@Given("^I make Post request to \"([^\"]*)\"$")
	public void i_make_Post_request_to(String url) throws Throwable {
		Base.setResponse(given().
				auth().oauth("KJgWOSJhg3HC5TyRN9lCq9h2i", 
				"YanqQJCMvsOehiMQWsgASqdPxHMXE1VYNQghnxBAWxGOFsDaRA", "1127284713977028609-zkflqDOqy012WWQQid5JlHAF370DEd", "Qrfs5EQqppGJ5b1gVenHzdLGlMuQDc6dhfvCJBJXMPh4g").
				formParam("status", "Posting tweet through API testing purpose" + LocalTime.now()).
                when().
                post(Base.baseURI + url));
	}
	
	@Given("^I make Post request to \"([^\"]*)\" to add new tweet \"([^\"]*)\"$")
	public void i_make_Post_request_to_to_add_new_tweet(String url, String tweet) throws Throwable {
		Base.setResponse(given().
				auth().oauth("KJgWOSJhg3HC5TyRN9lCq9h2i", 
				"YanqQJCMvsOehiMQWsgASqdPxHMXE1VYNQghnxBAWxGOFsDaRA", "1127284713977028609-zkflqDOqy012WWQQid5JlHAF370DEd", "Qrfs5EQqppGJ5b1gVenHzdLGlMuQDc6dhfvCJBJXMPh4g").
				formParam("status", tweet).
                when().
                post(Base.baseURI + url));
		System.out.println("Response data of new post is" + Base.getResponse().asString());
	}

	@Given("^I make Delete request to \"([^\"]*)\"$")
	public void i_make_Delete_request_to(String url) throws Throwable {
		Response r= Base.getResponse();
		long id = Base.getResponse().jsonPath().get("id");
		System.out.println("Tweet id is " + id );
		Base.setResponse(given().
				auth().oauth("KJgWOSJhg3HC5TyRN9lCq9h2i", 
				"YanqQJCMvsOehiMQWsgASqdPxHMXE1VYNQghnxBAWxGOFsDaRA", "1127284713977028609-zkflqDOqy012WWQQid5JlHAF370DEd", "Qrfs5EQqppGJ5b1gVenHzdLGlMuQDc6dhfvCJBJXMPh4g").
                when().
                post(Base.baseURI + url + id + ".json"));
		System.out.println("Tweet is deleted successfully");
	}
}
