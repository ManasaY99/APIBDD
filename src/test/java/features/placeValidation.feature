
Feature: Validating Place API's
  

  @AddPlace
  Scenario Outline: Verify that the place is successfully added using AddPlaceAPI
    Given AddPlace Payload with "<name>","<language>","<phonenumber>"
    When user calls "AddPlaceAPI" with "get" https request
    Then the API call got success with status code 200
    And "status" in responsebody is "OK"
    And "scope" in responsebody is "APP"
    Then verify place_Id created maps to "<name>" using "getPlaceAPI"
   Examples: 
    |name| language| phonenumber|
    |AAhouse|English|123-890-899|
    |AAhouse|Swedish|123-890-900|
    
    
@deletePlaces
    
    
    Scenario:verify that the place is deleted successfully using DeletePlaceAPI
    	Given DeletePlace payload
    	When user calls "DeletePlaceAPI" with "POST" https request
    	Then the API call got success with status code 200
   		 And "status" in responsebody is "OK"
    	
 
