package com.kfpanda.util;

/**
 * Enum工具类
 * @author awifi-core
 * @date 2015年1月7日 下午7:19:59
 */
public class EnumUtils {
	/**
	 * 判断某个枚举是否定义
	 * @param ems 枚举数组
	 * @param emStr 
	 * @return
	 */
	public static boolean isDefined(Enum<?> [] ems, String emStr){
		for (Enum<?> em : ems){
			if (em.toString().equals(emStr)) return true;
		}
		return false;
	}
	
	/**
	 * 判断某个枚举是否被定义
	 * @param emStr
	 * @return
	 */
//	public static boolean isDefined(String emStr){
//		for(Enum<?> em:Color.values()){
//			if (em.toString().equals(emStr)) return true;
//		}
//		return false;
//	}
	public static void main(String[] args){
//		System.out.println(isDefined("YELLOW"));
	}
}
