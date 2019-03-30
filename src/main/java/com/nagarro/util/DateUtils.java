package com.nagarro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Converts string to date
 */
public class DateUtils {

	public static Date stoDate(String dat) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		Date flightDate = sf.parse(dat);
		return flightDate;
	}
}