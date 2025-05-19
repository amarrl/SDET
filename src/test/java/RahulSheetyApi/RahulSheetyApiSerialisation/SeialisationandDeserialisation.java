package RahulSheetyApi.RahulSheetyApiSerialisation;

import static io.restassured.RestAssured.given;

import java.util.List;

import RahulSheetyApi.Pojo.GetCourses;
import RahulSheetyApi.Pojo.WebAutomation;
import RahulSheetyApi.Pojo.api;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class SeialisationandDeserialisation {
	
	
	public static void main(String[]args) {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		
		String res= given().log().all().header("Content-Type","application/x-www-form-urlencoded")
				.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.formParams("grant_type","client_credentials")
				.formParams("scope","trust")
				.when().log().all().post("oauthapi/oauth2/resourceOwner/token")
	.then().assertThat().statusCode(200).extract().asString();
		
		JsonPath js=new JsonPath(res);   
		String access_token=js.getString("access_token");
		  
		 
		GetCourses Getcoursedetails=given().param("access_token", ""+access_token+"")
		.when().log().all().get("oauthapi/getCourseDetails")
		.then().log().all().assertThat().statusCode(401).extract().as(GetCourses.class);
		
		  
		 
		 
		System.out.println(Getcoursedetails.getLinkedIn());   
		System.out.println(Getcoursedetails.getInstructor());
		System.out.println(Getcoursedetails.getCourses().getApi().get(1).getCourseTitle()); 
		 
		 
		//	WebAutomation Courses 
		
		List<WebAutomation>webcourse=Getcoursedetails.getCourses().getWebAutomation(); 
		System.out.println("----------------");
				
		for(int i=0;i<webcourse.size();i++) { 
			System.out.println(webcourse.get(i).getCourseTitle()); 
		 
		}
		
		//API courses Prices
		List<api>apidetails=Getcoursedetails.getCourses().getApi();
		
		for(int j=0;j<apidetails.size();j++) {
			System.out.println(apidetails.get(j).getPrice());
		}
		
	}

}
 