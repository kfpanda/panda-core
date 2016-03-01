package com.kfpanda.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * 日期工具类
 * @author kfpanda
 * @date 2015年1月7日 下午4:16:38
 */
public class DateUtil {

	public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_DATE = "yyyy-MM-dd";
	
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD_HH_MM_DASH = "yyyy-MM-dd_HH:mm";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	/**
	 * 时间戳转字符串
	 * @param timestamp 时间戳
	 * @param pattern 格式
	 * @return String 
	 */
	public static String timestamp2String(Timestamp timestamp, String pattern) {
		if (timestamp == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date(timestamp.getTime()));
	}

	/**
	 * 日期转字符串
	 * @param date 日期
	 * @param pattern 格式
	 * @return
	 */
	public static String date2String(java.util.Date date, String pattern) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
			;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 取得当前的时间戳
	 * @return
	 */
	public static Timestamp currentTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 按一定格式返回当前时间戳
	 * @param pattern
	 * @return
	 * @deprecated 此方法会涉及到date 转成timestamp 再转成date 再 格式化 不建议使用 
	 */

	public static String currentTimestamp2String(String pattern) {
		return timestamp2String(currentTimestamp(), pattern);
	}

	/**
	 * 日期字符串返回时间戳 
	 * @param strDateTime 时间字符串
	 * @param pattern 格式
	 * @return 
	 */
	public static Timestamp string2Timestamp(String strDateTime, String pattern) {
		if (strDateTime == null || strDateTime.equals("")) {
			throw new java.lang.IllegalArgumentException("Date Time Null Illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(strDateTime);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return new Timestamp(date.getTime());
	}

	/**
	 * 日期字符串返回日期
	 * @param strDate 日期字符串
	 * @param pattern 格式
	 * @return
	 */
	public static Date string2Date(String strDate, String pattern) {
		if (strDate == null || strDate.equals("")) {
			throw new RuntimeException("str date null");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = DateUtil.PATTERN_DATE;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;

		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	/**
	 * 取得年份
	 * @param strDest
	 * @return
	 */
	public static String stringToYear(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return String.valueOf(c.get(Calendar.YEAR));
	}

	/**
	 * 取得月
	 * @param strDest
	 * @return
	 */
	public static String stringToMonth(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// return String.valueOf(c.get(Calendar.MONTH));
		int month = c.get(Calendar.MONTH);
		month = month + 1;
		if (month < 10) {
			return "0" + month;
		}
		return String.valueOf(month);
	}

	/**
	 * 取得天
	 * @param strDest
	 * @return
	 */
	public static String stringToDay(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// return String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			return "0" + day;
		}
		return "" + day;
	}

	/**
	 * 取得一月的第一天
	 * @param c 日历
	 * @return
	 */
	public static Date getFirstDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = 1;
		c.set(year, month, day, 0, 0, 0);
		return c.getTime();
	}

	/**
	 * 取得一月 的最后一天
	 * @param c
	 * @return
	 */
	public static Date getLastDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = 1;
		if (month > 11) {
			month = 0;
			year = year + 1;
		}
		c.set(year, month, day - 1, 0, 0, 0);
		return c.getTime();
	}

	/**
	 * 日期转换GregorianCalendarString
	 * @param date
	 * @return
	 */
	public static String date2GregorianCalendarString(Date date) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("Date is null");
		}
		long tmp = date.getTime();
		GregorianCalendar ca = new GregorianCalendar();
		ca.setTimeInMillis(tmp);
		try {
			XMLGregorianCalendar t_XMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(ca);
			return t_XMLGregorianCalendar.normalize().toString();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			throw new java.lang.IllegalArgumentException("Date is null");
		}

	}

	/**
	 * 比较两个日期是否相等
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static boolean compareDate(Date firstDate, Date secondDate) {
		if (firstDate == null || secondDate == null) {
			throw new java.lang.RuntimeException();
		}

		String strFirstDate = date2String(firstDate, "yyyy-MM-dd");
		String strSecondDate = date2String(secondDate, "yyyy-MM-dd");
		if (strFirstDate.equals(strSecondDate)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 取得某天的初始时刻
	 * @param currentDate 日期
	 * @return
	 */
	public static Date getStartTimeOfDate(Date currentDate) {
//		Assert.notNull(currentDate);
		String strDateTime = date2String(currentDate,"yyyy-MM-dd") + " 00:00:00";
		return string2Date(strDateTime,"yyyy-MM-dd hh:mm:ss");
	}
	
	/**
	 * 取得某天的结束时刻
	 * @param currentDate 日期
	 * @return
	 */
	public static Date getEndTimeOfDate(Date currentDate) {
//		Assert.notNull(currentDate);
		String strDateTime = date2String(currentDate,"yyyy-MM-dd") + " 59:59:59";
		return string2Date(strDateTime,"yyyy-MM-dd hh:mm:ss");
	}

	


	/**
	 * 说明:根据指定格式转换成日期字符串
	 * @param date
	 * @param format
	 * @return String
	 * @author dozen.zhang
	 * @date 2015年6月5日上午10:44:36
	 */
	public static String formatToString(Date date, String format) {
		if(date==null){
			return "";
		}
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	
	/**
	 * 说明: 得到当前日期字符串
	 * @return String
	 * @author dozen.zhang
	 * @date 2015年6月5日上午10:42:31
	 */
	public static String getTodayDate() {
		return formatToString(new Date(), YYYY_MM_DD);
	}
	
	/**
	 * 说明:获取当前时间 yyyy-MM-dd HH:mm:ss
	 * @return String
	 * @author dozen.zhang
	 * @date 2015年6月5日上午10:47:12
	 */
	public static String getNow() {
		return formatToString(new Date(), YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 *  说明:获取当前时间 yyyy-MM-dd HH:mm:ss
	 * @return Date
	 * @author dozen.zhang
	 * @date 2015年6月5日上午10:49:47
	 */
	public static Date getNowDate() {
		return parseToDate(formatToString(new Date(), YYYY_MM_DD_HH_MM_SS),
				YYYY_MM_DD_HH_MM_SS);
	}
	
	/**
	 * 说明: 字符串转日期
	 * @param s 日期
	 * @param format 格式
	 * @return
	 */
	public static Date parseToDate(String s, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(s);
		} catch (ParseException e) {
			// e.printStackTrace();
			//System.err.println(s + "日期格式不对");
			return null;
		}
	}
	
	/**
	 * 说明:自动匹配日期格式 把字符串转成日期
	 * @param s 日期
	 * @return Date
	 */
	public static Date parseToDateTry(String s) {
		Date v = null;
		if (s.length() == DateUtil.YYYY_MM_DD.length()) {
			v = DateUtil.parseToDate(s, DateUtil.YYYY_MM_DD);
		} else if (s.length() == DateUtil.YYYY_MM_DD_HH_MM_SS.length()) {
			v = DateUtil.parseToDate(s, DateUtil.YYYY_MM_DD_HH_MM_SS);
		} else if (s.length() == DateUtil.YYYYMMDDHHMMSS.length()) {
			v = DateUtil.parseToDate(s, DateUtil.YYYYMMDDHHMMSS);
		} else if (s.length() == DateUtil.YYYYMMDD.length()) {
			v = DateUtil.parseToDate(s, DateUtil.YYYYMMDD);
		} else if (s.length() == "yyyy/MM/dd HH:mm".length()) {
			v = DateUtil.parseToDate(s, "yyyy/MM/dd HH:mm");
		} else {
			System.err.println("Unsupported date string format: " + s);
			return v;
		}
		return v;
	}
	

	/**
	 * 说明:将毫秒数转成 HH:MM:SS格式字符串
	 * @param time 毫秒数
	 * @return String HH:MM:ss
	 */
	public static String formatMillisecond(long time) {
		time = time / 1000;
		long hh = time / 60 / 60;
		long mm = time / 60 % 60;
		long ss = time % 60;
		return (hh < 10 ? "0" + hh : hh) + ":" + (mm < 10 ? "0" + mm : mm)
				+ ":" + (ss < 10 ? "0" + ss : ss);
	}
	
		/**
		 * 说明:判断日期格式是否正确
		 * @param date 日期
		 * @param format 格式
		 * @return boolean
		 */
		public static boolean checkDate(String date, String format) {
			DateFormat df = new SimpleDateFormat(format);
			Date d = null;
			try {
				d = df.parse(date);
			} catch (Exception e) {
				// 如果不能转换,肯定是错误格式
				return false;
			}
			String s1 = df.format(d);
			// 转换后的日期再转换回String,如果不等,逻辑错误.如format为"yyyy-MM-dd",date为
			// "2006-02-31",转换为日期后再转换回字符串为"2006-03-03",说明格式虽然对,但日期
			// 逻辑上不对.
			return date.equals(s1);
		}
		
		/**
		 * 说明:判断字符串是否是合法日期格式
		 * @param format
		 * @return boolean
		 */
		public static boolean checkStrDate(String format) {
			try {
				parseToDateTry(format);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
	
		/**
		 * 说明: excel日期解析 返回Date
		 * @param jxlDate
		 * @return Date
		 */
		public static Date convertDate4JXL(Date jxlDate) {
			if (jxlDate == null) {
				return null;
			}
			TimeZone gmt = TimeZone.getTimeZone("GMT");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
					Locale.getDefault());
			dateFormat.setTimeZone(gmt);
			String str = dateFormat.format(jxlDate);
			TimeZone local = TimeZone.getDefault();
			dateFormat.setTimeZone(local);
			try {
				return dateFormat.parse(str);
			} catch (ParseException e) {
				return null;
			}
		}
		
		/**
		 * 说明: excel日期解析 返回String
		 * @param jxlDate
		 * @return String
		 */
		public static String strDate4JXL(Date jxlDate) {
			if (jxlDate == null) {
				return "";
			}
			TimeZone gmt = TimeZone.getTimeZone("GMT");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
					Locale.getDefault());
			dateFormat.setTimeZone(gmt);
			return dateFormat.format(jxlDate);
		}
		
		/**
		 * 说明:返回一个月份的最后一天
		 * @param time 2015-12
		 * @return String 2015-12-31
		 */
		public static String getMonthLastDay(String time) {
			int yy = Integer.parseInt(time.substring(0, 4));
			int mm = Integer.parseInt(time.substring(5));
			String endTime = "";
			boolean r = yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0;
			if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10
					|| mm == 12) {
				endTime = time + "-31";
			} else if (mm != 2) {
				endTime = time + "-30";
			} else {
				if (r) {
					endTime = time + "-29";
				} else {
					endTime = time + "-28";
				}
			}
			return endTime;
		}
		/**
		 * 
		 * 说明:日期增加
		 * @param dateStr
		 * @param plus
		 * @return
		 */
		public static String dayAdd(String dateStr, int plus){
			Date date = parseToDate(dateStr, YYYY_MM_DD);
			Date resultDate = new Date(date.getTime() + plus*24*60*60*1000);
			return formatToString(resultDate, YYYY_MM_DD);
		}
		
		public static void main(String[] args){
//			System.out.println(new Timestamp(new Date().getTime()));
//			System.out.println(timestamp2String(new Timestamp(new Date().getTime()),"yyyy/MM/dd"));
//			System.out.println(date2String(new Date(),"yyyy/MM/dd HH:mm:ss"));
//			System.out.println(stringToYear("2222-12-12"));
			
			System.out.println(getMonthLastDay("2015-12"));
		}
		
}