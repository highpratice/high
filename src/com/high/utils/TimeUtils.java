package com.high.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {

	public static String formatTimeForSolr(Date date){
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");  
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");  
//		sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));  
		String result = sdf1.format(date) + "T" + sdf2.format(date) + "Z";  
		return result; 
	}
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		String date = formatTimeForSolr(d);
		System.out.println(date);
	}
}
