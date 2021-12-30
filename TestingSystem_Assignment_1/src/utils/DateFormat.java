package utils;

import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
private static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy") {
	
	public static String dateToStr(Date date, String pattern) {
		if (pattern !=null) {
			format = new SimpleDateFormat(pattern);
		}
	return format.format(date);
}
	public static Date strDate(String date, String pattern) {
		if (pattern !=null) {
			format = new SimpleDateFormat(pattern);
		}
		Date d = null;
		
		try {
			d= format.parse(date);
		}catch (ParseException e) {
			if (pattern !=null) {
				System.out.println("Truyen vao sai dinh dang =>"+ pattern);
			}else {
				System.err.println("Truyen vao sai dinh dang => dd-MM-yyyy" );
			}
			}
		}
		}
		
	

public static String dateToStr(Date date, String pattern) {

	return null;
}
public static Date strToDate(String string, Object object) {
	// TODO Auto-generated method stub
	return null;
}}
	
}
