package com.kdp.apiTestingRestAssured.stepDefination;

import com.kdp.apiTestingRestAssured.base.Base;

import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

public class FollowersSteps {
	
	@Then("^Response should contain follower list$")
	public void response_should_contain_follower_list() throws Throwable {
		Response r= Base.getResponse();
		List<String> user = Base.getResponse().jsonPath().getList("users.name");
		
		for(String a : user) {
			
			System.out.println("user name is " + a.toString());			
		}
	}
	
	@Then("^Response should contain follower details$")
	public void response_should_contain_follower_details() throws Throwable {
		Response r= Base.getResponse();
  
		
		/*List<Long> userId = Base.getResponse().jsonPath().getList("users.id");
		System.out.println("user ID are " + userId);	
		
		for(Long a : userId) {
			
			System.out.println("user ID is " + a.longValue());	
		}*/
		
		String nextCursor = Base.getResponse().jsonPath().getString("next_cursor");
		System.out.println("Next cursor is " + nextCursor);
		
	}
}
