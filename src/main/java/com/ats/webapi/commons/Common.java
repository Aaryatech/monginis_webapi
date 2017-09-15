package com.ats.webapi.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

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

}
