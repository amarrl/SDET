package RahulSheetyApi;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class DynamicJson {
	

	
	String token;
	String token2;
	String orderid;
	

	 
	//get token

	@Test(priority=1,dataProvider="booking ids") 
	    	public void genarateToken(String name,String email) {
			
			RestAssured.baseURI="https://simple-books-api.glitch.me/";
			 
			
			  
			 
			 
			String RESPONSE=given().log().all().headers("Content-Type", "application/json")
			.body("{\r\n"
					+ "    \"clientName\": \""+name+"\",\r\n"
					+ "    \"clientEmail\":\""+email+"\"\r\n"
					+ "\r\n" 
					+ "}")
			.when().log().all().post("api-clients/")
			.then().log().all().statusCode(201).extract().response().asString();
		
			 
			JsonPath json1=	new JsonPath(RESPONSE.toString());
			token=json1.getString("accessToken"); 
			 
			JsonPath json2=	new JsonPath(RESPONSE.toString());
			token2=json2.getString("accessToken"); 
			  
		
}
	
	
	
	//create order
	
	    	@Test(priority=2,dataProvider="Create order") 
	    	public void submitOrder(String id,String email) {
	    		RestAssured.baseURI="https://simple-books-api.glitch.me/";
				
	    		String orderdetails=given().log().all().headers("Content-Type", "application/json").headers("Authorization",token)
	    		.body("{\r\n"
	    				+ "\"bookId\":\""+id+"\",\r\n"
	    				+ "    \"clientEmail\":\""+email+"\"\r\n" 
	    				+ "\r\n"
	    				+ "}")
	    		.when().log().all().post("orders")
	    		.then().log().all().statusCode(201).extract().response().asString();
	    		
	    		
	    		JsonPath json=	new JsonPath(orderdetails);
	    		orderid=json.getString("orderId");
	    		
	    		
	    	}
	    	 
	    	
	    	//get order details
	    	
	    	
	    	@Test(priority=3,dataProvider="get order")
	    	public void getOrder() {
	    		RestAssured.baseURI="https://simple-books-api.glitch.me/";
				
	    		String getorderdetails=given().log().all().headers("Content-Type", "application/json").headers("Authorization",token)
	    		
	    		.when().log().all().get("orders/"+orderid+"")
	    		.then().log().all().statusCode(200).extract().response().asString();
	    		
	    		
	    		JsonPath json=	new JsonPath(getorderdetails);
	    		orderid=json.getString("id"); 
	    		
	    		
	    	}
	    	/*
	    	//delete order
	    	
	    	@Test(priority=4,dataProvider="Create order")
	    	public void deleteOrder() {
	    		RestAssured.baseURI="https://simple-books-api.glitch.me/";
				
	    		String getorderdetails=given().log().all().headers("Content-Type", "application/json").headers("Authorization",token)
	    		
	    		.when().log().all().delete("orders/"+orderid+"")
	    		.then().log().all().statusCode(204).extract().response().asString();
	    		 
	    		
	    		 
	    		
	    		
	    	}
	    	
	    		*/
	    	
	    	@DataProvider(name="booking ids")
	    	public Object[][]getdata(){
	    		String random1=RandomStringUtils.randomAlphanumeric(12);
	    		random1=random1+"@gmail.com";
	    		
	    		String random2=RandomStringUtils.randomAlphanumeric(11);
	    		random2=random2+"@gmail.com";
	    		
	    	Object	data[][]= {
	    				
	    				{"Amar",""+random1+""},
	    				{"Raj",""+random2+""}
	    		};
	    		
	    		return data;
	    	}
	    	 
	    	@DataProvider(name="Create order")
	    	
	    	public Object[][]createOrder(){
	    		Object data1[][]= {
	    				{"1","Amar"},
	    				{"2","Raj"}
	    		};
	    		
	    		return data1;
	    	}
	    	
	    	
}


