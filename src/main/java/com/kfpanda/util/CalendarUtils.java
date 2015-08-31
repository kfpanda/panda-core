package com.kfpanda.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日历操作工具
 * @author awifi-core
 * @date 2015年1月7日 下午12:00:20
 */
public class CalendarUtils {
	
	private CalendarUtils() {}
	
	/**
	 * 增加日期 将value增加在指定的field
	 * @param field  被增加的地方 年 月 日等 注：Calendar中月是从0开始的
	 * @param date 	日期
	 * @param value	值
	 * @return Date 
	 */
	public static Date add(int field,Date date,int value) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		int fieldNewValue = (c.get(field) + value);
		c.set(field, fieldNewValue);
		return c.getTime();
	}
 
	/**
	 * 取出指定field的日期
	 * @param field 年 月 日等 注：Calendar中月是从0开始的
	 * @param date 日期
	 * @return
	 */
	public static int get(int field,Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(field);
	}
	
	/**
	 * 比较两个日期指定field的值
	 * @param field  年 月 日等 注：Calendar中月是从0开始的
	 * @param d1 日期
	 * @param d2 日期
	 * @return
	 */
	public static boolean isEqualField(int field, Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		return c1.get(field) == c2.get(field);
	}
	
	public static void main(String[] args) throws ParseException{
		String sDate = "2012-12-12";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(sDate);
		
		System.out.println(get(Calendar.YEAR,date)+"-"+get(Calendar.MONTH,date)+"-"+get(Calendar.DATE,date));
	}
	
	
}
