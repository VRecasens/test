package fr.humanbooster.liaison.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Dates {

	/**
	 * java.util.Calendar to Date
	 * @param c Calendar
	 * @return Date
	 */
	public static Date convertCalendarToDate(Calendar c) {
		return c.getTime();
	}
	
	/**
	 * java.util.Date to Calendar
	 * @param d Date
	 * @return Calendar
	 */
	public static Calendar convertDateToCalendar(Date d){
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}
	
	/**
	 * java.util.Date to SQL Date
	 * @param dateUtil Date
	 * @return java.sql.Date
	 */
	public static java.sql.Date convertUtilDateToSqlDate(java.util.Date dateUtil){		
		return new java.sql.Date(dateUtil.getTime());
	}
	
	
	/**
	 * java.sql.Date to Util Date
	 * @param dateSql Sql date format
	 * @return java.util.Date
	 */
	public static java.util.Date convertSqlDateToUtilDate(java.sql.Date dateSql){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(dateSql.getTime());
		return c.getTime();
	}
	
	/**
	 * java.util.Date to String
	 * @param d Date
	 * @return String
	 */
	public static String formatDate(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
		return sdf.format(d);
	}
	
	// Format birthDate
	public static String formatDateBirth(Date d){
		if(d != null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
			return sdf.format(d);
		} else {
			return "";
		}
	}
	
	/**
	 * String Date to java.util.Date
	 * @param date Date
	 * @return java.util.Date
	 */
	public static Date getDateFromString(String date){
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
		Date parseDate = new Date();
		
		try {
			parseDate = df.parse(date);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		return parseDate;
	}
	
	/**
	 * Diff�rence en ms entre 2 dates
	 * @param d1 long
	 * @param d2 long
	 * @return long
	 */
	public static long getDifferenceBetweenTwodates(Date d1, Date d2){
		long time1 = d1.getTime();
		long time2 = d2.getTime();
		long diffInMs = time2 - time1;
		long diffInday = diffInMs/(1000*60*60*24);		
		return diffInday;
	}
	
	/**
	 * Compare two dates
	 * @param d1 long
	 * @param d2 long
	 * @return int
	 */
	public static int compareTwoDates(Date d1, Date d2){
		int result = 2;
		if(d1.equals(d2)){
			result = 0;
		} else if(d1.before(d2)){
			result = -1;
		} else if(d1.after(d2)){
			result = 1;
		}
		
		return result;
	}
	
}
