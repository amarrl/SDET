package RahulSheetyApi;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulSheetyApi.PlayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LibararyApi { 
	String ID;
	@Test(priority=1,dataProvider="Books data")
	public void addBook(String name,String idn) {
		RestAssured.baseURI="http://216.10.245.166";
		
		String libresponse=given().log().all().header("Content-Type","application/json")
		.body(PlayLoad.AddLib(name,idn))
		.when().post("Library/Addbook.php")
		.then().log().all().statusCode(200).extract().response().asString();
		
		System.out.println(libresponse);
		 
		JsonPath js=new JsonPath(libresponse);
		 ID=js.getString("ID");
		System.out.println(ID);
	} 
		
		@Test(priority=2,dataProvider="Books data")
		
		//delete
		
		public void deleteBook(String name,String idn) {
		String responsedelete=given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+ID+"\"\r\n" 
				+ " \r\n"
				+ "} \r\n"
				+ "")
		.when().post("Library/DeleteBook.php")
		.then().log().all().assertThat().statusCode(204).extract().response().asString();
		
		JsonPath deletelib=new JsonPath(responsedelete);
		String msgres= deletelib.getString("msg");
		
		Assert.assertEquals(msgres, "book is successfully deleted");

		
		
	}
	
		@DataProvider(name="Books data")
		public Object[][] getData() {
			//array=collection of elements
			//multiDimenstional array=collection of arrays
			return new Object[][] {
				{"iosd","1991"},{"san","1881"},{"jna","1881"}
				
			};	
		} 
	
		
		
	}
	

