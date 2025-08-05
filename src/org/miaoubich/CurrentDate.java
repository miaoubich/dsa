package org.miaoubich;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class CurrentDate {

	public static void main(String[] args) throws ParseException {

		monthYearDate();
		
		LocalDate today = LocalDate.now();
		System.out.println("Today date: " + today);
		
		dateConverter("2025-05-16 21:20:11.966");
		
	}

	private static void monthYearDate() {
		LocalDate today = LocalDate.now();
//        int day = today.getDayOfMonth();
//        int month = today.getMonthValue();
//        int year = today.getYear();
		
        String todayString = String.valueOf(today);
		String monthYear = todayString.substring(5, 7).concat(todayString.substring(0, 4));

        System.out.println(today);
//        System.out.println("Today's Date: " + day);
//        System.out.println("Current Month: " + month);
//        System.out.println("Current Year: " + year);
        
        System.out.println("monthYear: " + monthYear);
	}
	
	private static String dateConverter(String date) throws ParseException {
        
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        java.util.Date javaDate = inputFormat.parse(date);
        
        SimpleDateFormat monthFormat = new SimpleDateFormat("M");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        
        String month = monthFormat.format(javaDate);
        String year = yearFormat.format(javaDate);
        
        String customDateFormat = month + year;
        
        System.out.println("Original date: "+ date);
        System.out.println("Converted format: " + customDateFormat);
        
        //42025
        //122025
        String yearMonth = customDateFormat.substring(customDateFormat.length()-4, customDateFormat.length()-1)
        		.concat(customDateFormat.length()%2==0?customDateFormat.substring(0, 3):customDateFormat.substring(0, 2));
        System.out.println("yearMonth: " + yearMonth);
        

		String customDateFormat1 = "022026";
		String yearMonth1 = customDateFormat1.substring(customDateFormat1.length()-4, customDateFormat1.length())
				.concat(customDateFormat1.substring(0,2));
		System.out.println("yearMonth1: " + yearMonth1);

        
		return customDateFormat;
	}

}
