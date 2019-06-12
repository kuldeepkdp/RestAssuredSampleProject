package com.kdp.apiTestingRestAssured.stepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import com.kdp.apiTestingRestAssured.base.Base;


public class TweetTimelinesSteps {
	
	@Given("^I make Get request to \"([^\"]*)\"$")
	public void i_make_Get_request_to(String url) throws Throwable {
		
		Base.setResponse(given().
				auth().oauth("KJgWOSJhg3HC5TyRN9lCq9h2i", 
				"YanqQJCMvsOehiMQWsgASqdPxHMXE1VYNQghnxBAWxGOFsDaRA", "1127284713977028609-zkflqDOqy012WWQQid5JlHAF370DEd", "Qrfs5EQqppGJ5b1gVenHzdLGlMuQDc6dhfvCJBJXMPh4g").
                when().
                get(Base.baseURI + url));

	
	}

	@Then("^Status code should be (\\d+)$")
	public void status_code_should_be(int code) throws Throwable {
		
		Response r= Base.getResponse();
		r.then().statusCode(code);
		
		System.out.println("Response date is" + r.asString());
				
	}
	
	@Given("^I make Get request to \"([^\"]*)\" having parameter \"([^\"]*)\" is equal to \"([^\"]*)\"$")
	public void i_make_Get_request_to_having_parameter_is_equal_to(String url, String param, String count) throws Throwable {
		Base.setResponse(given().
				auth().oauth("KJgWOSJhg3HC5TyRN9lCq9h2i", 
				"YanqQJCMvsOehiMQWsgASqdPxHMXE1VYNQghnxBAWxGOFsDaRA", "1127284713977028609-zkflqDOqy012WWQQid5JlHAF370DEd", "Qrfs5EQqppGJ5b1gVenHzdLGlMuQDc6dhfvCJBJXMPh4g").
				param("count", count).
				when().get(Base.baseURI + url));
        
	}
	
	@Then("^response should retun (\\d+) tweets$")
	public void response_should_retun_tweets(int count) throws Throwable {
		Response r= Base.getResponse();
        List<String> tweet = Base.getResponse().jsonPath().getList("text");
		
		for(String a : tweet) {
			
			System.out.println("Tweets are " + a.toString());			
		}
		
		int actualTweetCount = tweet.size();
		Assert.assertEquals(count, actualTweetCount);
	
	}

}
