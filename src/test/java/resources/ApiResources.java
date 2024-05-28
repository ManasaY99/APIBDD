package resources;

public enum ApiResources {
	AddPlaceAPI("/maps/api/place/add/post/json"),
	GetPlaceAPI("/maps/api/place/get/post/json"),
	DeletePlaceAPI("/maps/api/place/delete/post/json");
	private String resource;
	
	ApiResources(String resource)
	{
		this.resource =resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
	
	

}
