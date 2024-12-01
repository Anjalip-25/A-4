package com.example.api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ApiTest {
	 @Test
	    public void testGetRequest() {
	        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertNotNull(response.getBody(), "Response body is null");
	    }

	    @Test
	    public void testPostRequest() {
	        Response response = RestAssured
	            .given()
	            .header("Content-Type", "application/json")
	            .body("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}")
	            .post("https://jsonplaceholder.typicode.com/posts");
	        Assert.assertEquals(response.getStatusCode(), 201);
	        Assert.assertTrue(response.getBody().asString().contains("\"id\""));
	    }

	    @Test
	    public void testInvalidEndpoint() {
	        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/invalid");
	        Assert.assertEquals(response.getStatusCode(), 404);
	    }

}
