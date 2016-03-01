package com.kfpanda.core.random;

import java.util.Random;

/**
 * 产生自定义长度的随机字符串
 * @author kfpanda
 * @date 2015年1月7日 上午10:25:20
 */
public class RandomString {
	
	private static char[] NUMBER_POOL = new char[]{'0','1','2','3','4','5','6','7','8','9'};
	
	private static Random random = new Random(System.currentTimeMillis());
	
	/**
	 * 产生自定义长度的随机字符串
	 * @param length 自定义长度
	 * @return
	 */
	public static String randomString(int length) {
		if (length <=0) {
			throw new java.lang.IllegalArgumentException();
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<length;i++) {
			int tmp = random.nextInt(10);
			sb.append(NUMBER_POOL[tmp]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
		System.out.println(randomString(8));
	}
	
}
