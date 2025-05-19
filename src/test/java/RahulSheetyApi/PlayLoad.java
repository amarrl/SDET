package RahulSheetyApi;

public class PlayLoad {


	public static String AddLib(String inp1,String inp2) {
		String addBookBoday="{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+inp1+"\",\r\n"
				+ "\"aisle\":\""+inp2+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
	 
	return addBookBoday;
	}


}
