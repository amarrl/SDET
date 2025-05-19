package RahulSheetyApi.RahulSheetyApiSerialisation;

import static io.restassured.RestAssured.given;

import RahulSheetyApi.Pojo.GetCourses;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Practice {
	
	public static void main (String[]args) {
		
			RestAssured.baseURI="https://rahulshettyacademy.com/";
			
			String res=given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
			.formParam("grant_type", "client_credentials")
			.formParam("scope", "trust")
			.when().log().all().post("oauthapi/oauth2/resourceOwner/token")
			.then().assertThat().statusCode(200).extract().response().asString();
			
			JsonPath js=new JsonPath(res); 
			
			String token=js.getString("access_token"); 
			 
			//get course details 
			
			GetCourses h=given().queryParam("access_token", ""+token+"")
			.when().log().all().post("oauthapi/getCourseDetails")
			.then().log().all().assertThat().statusCode(401).extract().as(GetCourses.class);
			
			 
		System.out.println(h.getLinkedIn()); 
		
	}

}
