package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {
	RequestSpecification rsb; 
	public RequestSpecification requestSpecification() throws IOException {
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));

	
	 rsb=new RequestSpecBuilder().setBaseUri(getGlobalValues("baseurl"))
			 .addQueryParam("key", "qaclick123")
			 .addFilter(RequestLoggingFilter.logRequestTo(log))
			 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			 .setContentType(ContentType.JSON).build();
	 return rsb;
	}
	
	public String getGlobalValues(String Key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fio=new FileInputStream("C:\\Users\\welco\\eclipse-workspacemaven\\APIBDDFrameworkRahulshetty\\src\\test\\java\\resources\\config.properties");
		prop.load(fio);
		 return prop.getProperty(Key);
	}
	
	public String getJsonpath(Response response2, String keyvalue)
	{
		String Respo= response2.toString();
		JsonPath js= new JsonPath(Respo);
		return js.get(keyvalue).toString();
		
	}

}
