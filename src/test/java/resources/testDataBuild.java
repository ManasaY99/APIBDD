package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.addPlace;
import pojo.location;

public class testDataBuild {
	
	public static addPlace AddPlaceAPI(String name, String language,String phonenumber )
	{
		addPlace ap= new addPlace();
		ap.setAccuracy(50);
		ap.setLanguage(language);
		ap.setName(name);
		ap.setPhone_number(phonenumber);
		ap.setWebsite("https://rahulshettyacadamy.com");
		//providing the data for array
		List<String> Types= new ArrayList<String>();
		Types.add("Shoe");
		Types.add("shoe mart");
		ap.setTypes(Types);
		//providing location details
		location lc= new location();
		lc.setLat(-0.8900);
		lc.setLng(9090.90);
		ap.setLocation(lc);
		return ap;
	}
	public String deletePlacePayload(String placeId) {
		return "{\r\n  \"place_Id\":\""+placeId+"\"\r\n}";
		
	}
}
