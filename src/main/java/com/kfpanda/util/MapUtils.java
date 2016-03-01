package com.kfpanda.util;

import java.util.Map;

/**
 * map 工具类
 * @author kfpanda
 * @date 2015年1月7日 下午7:50:23
 */
public class MapUtils {
	
	/**
	 * 如果map的值为空，则放入默认的值
	 * @param map 
	 * @param key 
	 * @param defaultValue 默认值
	 */
	@SuppressWarnings("all")
	public static void putIfNull(Map map,Object key,Object defaultValue) {
		if(key == null)
			throw new IllegalArgumentException("key must be not null");
		if(map == null)
			throw new IllegalArgumentException("map must be not null");
		if(map.get(key) == null) {
			map.put(key, defaultValue);
		}
	}
	
}
