package com.kdp.apiTestingRestAssured.base;

import io.restassured.response.Response;

public class Base {
	
	public static Response response;
	public static String baseURI = "https://api.twitter.com/1.1/";
	
	public static Response getResponse() {
		return response;
	}

	public static void setResponse(Response response) {
		Base.response = response;
	}
}
