package RestAsure1;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;


public class hitUrl {
	 String url = "http://demo.guru99.com/V4/sinkministatement.php";
	public static void main(String [] args)
	{
		 hitUrl a =new hitUrl();
		 a.getResponseBody();
		 System.out.println("This is using Query & Param");
		 a.getResponseBodyQueryParam();
		 a.getresponseStatus();
		 a.getResponseHeaders();
		 a.getResponseTime();
		 System.out.println("Json");
		 a.getSpecificPartOfResponseBodyasString();
		 a.getSpecificPartOfResponseBody();
		 
		  
		 
	}
	 public void getResponseBody(){
		   given()
		   .when()
		   .get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
		   .then()
		   .log().all();
	}
	 
	 public void getResponseBodyQueryParam()
	 {
		 given()
		 .queryParam("CUSTOMER_ID","68195")
		 .queryParam("PASSWORD","1234!")
		 .queryParam("Account_No","1")
		 .when()
		 .get(url)
		 .then()
		 .log().all();
	 }
		 
	public void getresponseStatus()
		 {
			 
		 
		 int statusCode=given()
				 .queryParam("CUSTOMER_ID","68195")
				 .queryParam("PASSWORD","1234!")
				 .queryParam("Account_No","1")
				 .when()
				 .get(url).getStatusCode();
		 System.out.println("Status Code"+statusCode);
		 
	 }
	public void getResponseHeaders()
	{
		
	
	    System.out.println("Response Headers " + get(url).then().extract().headers());
	}
	public void getResponseTime()
	{
		System.out.println("Response Time"+ get(url).timeIn(TimeUnit.MILLISECONDS));
	//Sstem.out.println("Response Time 2" + get(url).getTime());
	}
	public void getSpecificPartOfResponseBodyasString()
	{
		String response =given().get("https://jsonplaceholder.typicode.com/todos/1").then().extract().asString();
		String title=response.substring(response.indexOf("\"title\":")+ 9,response.indexOf("\"completed\""));
		System.out.println(title);
	}
	
	public void getSpecificPartOfResponseBody()
	{
		String title =given()
		.get("https://jsonplaceholder.typicode.com/todos/1").then()
		.extract().jsonPath().getString("title");
		
		System.out.println(title);
		
	}
}
