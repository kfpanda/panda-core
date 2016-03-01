package com.kfpanda.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * array操作工具
 * @author kfpanda
 * @date 2015年1月7日 上午11:59:50
 */
public class ArrayUtils { 
	
	private ArrayUtils(){}
	
	/**
	 * 将一个array转为根据keys转为LinkedHashMap
	 * @param array 按顺序排好的value值
	 * @param keys 按顺序排好的key值
	 * @return LinkedHashMap
	 */
	@SuppressWarnings("all")
	public static Map toMap(Object[] array,String...keys) {
		if(array == null) return new HashMap();
		Map m = new LinkedHashMap();
		for(int i = 0; i < keys.length; i++) {
			if(array.length == i ) {
				break;
			}
			m.put(keys[i], array[i]);
		}
		return m;
	}
}
