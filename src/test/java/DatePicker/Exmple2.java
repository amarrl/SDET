package DatePicker;

import java.time.Month;
import java.util.Date;
import java.util.HashMap;

public class Exmple2 {

	public static void main(String[] args) {
		//User defined method for converting String month to Month Object
		
		HashMap<String,Month> monthMap=new HashMap<String,Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH); 
		monthMap.put("APRIL", Month.APRIL);
		monthMap.put("MAY", Month.MAY);
		monthMap.put("JUNE", Month.JUNE);
		monthMap.put("JULY", Month.JULY);
		monthMap.put("AUGUST", Month.AUGUST);
		monthMap.put("SEPTEMBER", Month.SEPTEMBER);
		monthMap.put("OCTOBER", Month.OCTOBER);
		monthMap.put("NOVEMBER", Month.NOVEMBER);
		monthMap.put("DECEMBER", Month.DECEMBER);
		
		Month s=monthMap.get("January");
		System.out.println(s);
		
		Date currentDate=new Date();
		
		System.out.println(currentDate.getDate());
		
		System.out.println(currentDate.getMonth());	


	}

}
