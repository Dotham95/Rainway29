package frontend;

import java.util.Date;

import utils.DateFormat;

public class PrintDate {
	public static void main(String[] args) {
		Date date;
		date = DateFormat.strToDate("25-12-2021", null);
		System.out.println(date);
		System.out.println(DateFormat.dateToStr(date, null));
	}
}
