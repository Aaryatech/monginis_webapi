package com.ats.webapi.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

	// test comment for mahesh
	
	// To convert string to ymd format date
	public static String convertToYMD(String date) {
		
		String convertedDate=null;
		try {
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy/mm/dd");
			SimpleDateFormat dmySDF = new SimpleDateFormat("dd/mm/yyyy");

			Date dmyDate = dmySDF.parse(date);
			
			convertedDate=ymdSDF.format(dmyDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedDate;

	}
	
	
	
public static java.sql.Date convertToSqlDate(String date) {
		
		java.sql.Date convertedDate=null;
		try {
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy/mm/dd");
			SimpleDateFormat dmySDF = new SimpleDateFormat("dd/mm/yyyy");

			Date dmyDate = dmySDF.parse(date);
			
			convertedDate=new java.sql.Date(dmyDate.getTime());
			System.out.println("converted date commons "+convertedDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedDate;

	}

	
	

}
