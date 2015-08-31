package com.kfpanda.util;

import java.util.Collection;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElUtility {

	/**
	 * 说明:检查集合中是否含有o
	 * @param o Object
	 * @param c Collection 集合
	 * @return boolean
	 */
	public static boolean contains(Object o, Collection<?> c) {
		if (c == null) {
			return false;
		}
		return c.contains(o);
	}

	/**
	 * 说明:截取字符串 多余的用...显示
	 * @param value
	 * @param length
	 * @return String
	 */
	public static String subStr(String value, Integer length) {
		if (value == null)
			return null;
		String regEx = "<.+?>";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(value);
		value = matcher.replaceAll("");

		value = value.replace("&nbsp;", " ");
		if (value.length() <= length)
			return value;
		else
			return value.substring(0, length) + "...";
	}

	/**
	 * 说明: url 参数修改
	 * @param url 原始url
	 * @param terms 参数
	 * @param updKey 更新的键
	 * @param updValue
	 * @param delKey 要删除的键
	 * @return String
	 */
	public static String curl(String url, String terms, String updKey,
			String updValue, String delKey) {
		StringBuilder sb = new StringBuilder(terms);

		if (updKey != null && updKey.length() > 0) {
			int start = sb.indexOf(updKey);
			if (start > 0) {
				int end = sb.indexOf("&", start);
				if (-1 == end)
					end = sb.length();
				sb.replace(start, end, updKey + "=" + updValue);
			} else {
				sb.append("&" + updKey + "=" + updValue);
			}
		}
		if (delKey != null && delKey.length() > 0) {
			int start = sb.indexOf(delKey);
			if (start > 0) {
				int end = sb.indexOf("&", start);
				if (-1 == end)
					end = sb.length();
				sb.delete(start, end);
			}
		}
		return url + sb.toString();
	}
	
	/**
	 * 说明:给定的值范围内取随机数
	 * @param start 最小值
	 * @param end 最大值
	 * @return
	 * @return Long
	 * @author dozen.zhang
	 * @date 2015年6月5日下午1:48:02
	 */
	public static Long random(Long start, Long end) {
		return Math.round(Math.random() * (end - start)) + start;
	}
	
	public static void main(String[] args){
		System.out.println(new Random().nextInt(100));
		System.out.println(random(8L,1L));
		System.out.println(subStr("abc",2));
	}
}
