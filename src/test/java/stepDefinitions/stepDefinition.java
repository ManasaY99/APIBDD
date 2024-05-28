package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.addPlace;
import pojo.location;
import resources.ApiResources;
import resources.testDataBuild;
import resources.utils;

public class stepDefinition extends utils {
	
	RequestSpecification req;
	ResponseSpecification response;
	Response response2;
	static String placeId;
	testDataBuild data = new testDataBuild();
	
	
	
	
	@Given("AddPlace Payload with {string},{string},{string}")
	public void add_place_payload_with(String name,String language, String phonemuber) throws IOException  {
	
		 
		 req=	given().spec(requestSpecification()).body(data.AddPlaceAPI(name,language,language));
		 
	    
	  
	}
	@When("user calls {string} with {string} https request")
	public void user_calls_with_post_https_request(String resource, String method) {
		ApiResources resouceapi=ApiResources.valueOf(resource);
		System.out.println(resouceapi.getResource());
		if (method.equalsIgnoreCase("POST"))
		
		 response2=req.when().post(resouceapi.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response2=req.when().get(resouceapi.getResource());
			
	   
	   
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response2.getStatusCode(), 200);
		
	    
	}
	@Then("{string} in responsebody is {string}")
	public void in_responsebody_is(String Actualvalue, String ExpectedValue) {
		
		assertEquals(getJsonpath(response2, Actualvalue),ExpectedValue);
	    
	}
	@Then("Verify place_Id created maps to {string} using {string}" )
	public void verify_place_Id_created_maps_to_using(String expectedName,String resource) throws IOException
	{
		getJsonpath(response2,"place_id");
		req=given().spec(requestSpecification()).queryParam("place_id", placeId);
		user_calls_with_post_https_request(resource, "GET");
		String ActualName=getJsonpath(response2,"name");
		assertEquals(ActualName,expectedName);
		
	}
	

	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
		req=given().spec(requestSpecification()).body(data.deletePlacePayload(placeId));
	  
	   
	}





}
 