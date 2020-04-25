package com.personal.job.portal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor {

	public static Date convertStringToDate(String inputDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = formatter.parse(inputDate);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
