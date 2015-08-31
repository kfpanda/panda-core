package com.kfpanda.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * <strong>Title : DateConvertUtils<br></strong>
 * <strong>Description : </strong>@类注释说明写在此处@<br> 
 * <strong>Create on : 2011-11-2<br></strong>
 * <p>
 * <strong>Copyright (C) Ecointel Software Co.,Ltd.<br></strong>
 * <p>
 * @author peng.shi peng.shi@ecointellects.com<br>
 * @version <strong>Ecointel v1.0.0</strong><br>
 * <br>
 * <strong>修改历史:</strong><br>
 * 修改人		修改日期		修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 * @author awifi-core
 * @date 2015年1月7日 上午11:47:42
 */
public class DateConvertUtils {
	
	/**
	 * 转换日期字符串
	 * @param dateString 日期字符串
	 * @param dateFormat 日期格式
	 * @return
	 */
	public static java.util.Date parse(String dateString,String dateFormat) {
		return parse(dateString, dateFormat,java.util.Date.class);
	}
	
	/**
	 * 转换日期字符串
	 * @param dateString 日期字符串
	 * @param dateFormat 日期格式
	 * @param targetResultType 返回值类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends java.util.Date> T parse(String dateString,String dateFormat,Class<T> targetResultType) {
		if(StringUtils.isEmpty(dateString))
			return null;
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			long time = df.parse(dateString).getTime();
			java.util.Date t = targetResultType.getConstructor(long.class).newInstance(time);
			return (T)t;
		} catch (ParseException e) {
			String errorInfo = "cannot use dateformat:"+dateFormat+" parse datestring:"+dateString;
			throw new IllegalArgumentException(errorInfo,e);
		} catch (Exception e) {
			throw new IllegalArgumentException("error targetResultType:"+targetResultType.getName(),e);
		}
	}
	
	/**
	 * 将日期转换为字符串
	 * @param date 日期
	 * @param dateFormat 格式
	 * @return
	 */
	public static String format(java.util.Date date,String dateFormat) {
		 if(date == null)
			 return null;
		 return new SimpleDateFormat(dateFormat).format(date);
	}
}
