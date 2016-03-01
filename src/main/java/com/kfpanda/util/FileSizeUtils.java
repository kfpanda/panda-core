package com.kfpanda.util;

import java.text.DecimalFormat;

/**
 * 文件大小工具类
 * @author kfpanda
 * @date 2015年1月7日 下午7:42:50
 */
public class FileSizeUtils {
	public static long ONE_KB = 1024;
	public static long ONE_MB = ONE_KB * 1024;
	public static long ONE_GB = ONE_MB * 1024;
	public static long ONE_TB = ONE_GB * (long)1024;
	public static long ONE_PB = ONE_TB * (long)1024;
	
	/**
	 * 说明:根据filesize 得到 文件大小字符串
	 * @param fileSize
	 * @return String
	 */
	public static String getHumanReadableFileSize(Long fileSize) {
		if(fileSize == null) return null;
		return getHumanReadableFileSize(fileSize.longValue());
	}
	
	/**
	 * 以字节为单位计算大小
	 * @param fileSize 
	 * @return String  ######.##PB or TB or GB or MB or KB
	 */
	public static String getHumanReadableFileSize(long fileSize) {
		if(fileSize < 0) {
			return String.valueOf(fileSize);
		}
		String result = getHumanReadableFileSize(fileSize, ONE_PB, "PB");
		if(result != null) {
			return result;
		}
		
		result = getHumanReadableFileSize(fileSize, ONE_TB, "TB");
		if(result != null) {
			return result;
		}
		result = getHumanReadableFileSize(fileSize, ONE_GB, "GB");
		if(result != null) {
			return result;
		}
		result = getHumanReadableFileSize(fileSize, ONE_MB, "MB");
		if(result != null) {
			return result;
		}
		result = getHumanReadableFileSize(fileSize, ONE_KB, "KB");
		if(result != null) {
			return result;
		}
		return String.valueOf(fileSize)+"B";
	}

	/**
	 * 说明:以指定单位显示文件大小
	 * @param fileSize
	 * @param unit
	 * @param unitName
	 * @return String
	 */
	private static String getHumanReadableFileSize(long fileSize, long unit,String unitName) {
		if(fileSize == 0) return "0";
		
		if(fileSize / unit >= 1) {
			double value = fileSize / (double)unit;
			DecimalFormat df = new DecimalFormat("######.##"+unitName);
			return df.format(value);
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println(getHumanReadableFileSize(10000L));
	}
}
