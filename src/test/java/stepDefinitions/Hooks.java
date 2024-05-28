package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("deletePlace")
	public void beforeScenario() throws IOException
	{
		
		stepDefinition m =new stepDefinition();
		if (stepDefinition.placeId==null)
		{
		m.add_place_payload_with("yella","Swedish","90890090");
		m.user_calls_with_post_https_request("AddPlaceAPI", "POST");
		}
		
	}

}
