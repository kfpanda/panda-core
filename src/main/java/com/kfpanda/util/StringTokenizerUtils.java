package com.kfpanda.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 字符串切分方法
 * @author kfpanda
 * @date 2015年1月8日 下午2:34:46
 */
public class StringTokenizerUtils {

    /**
     * 将str将多个分隔符进行切分，
     * 
     * 示例：StringTokenizerUtils.split("1,2;3 4"," ,;");
     * 返回: ["1","2","3","4"]
     * 
     * @param str
     * @param seperators
     * @return
     */
	@SuppressWarnings("all")
	public static String[] split(String str,String seperators) {
		StringTokenizer tokenlizer = new StringTokenizer(str,seperators);
		List result = new ArrayList();
		
		while(tokenlizer.hasMoreElements()) {
			Object s = tokenlizer.nextElement();
			result.add(s);
		}
		return (String[])result.toArray(new String[result.size()]);
	}
	
}
