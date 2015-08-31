/*
 * Created on 2007-1-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.kfpanda.core.random;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 产生唯一的随机字符串
 * @author awifi-core
 * @date 2015年1月7日 上午10:22:33
 */
public class RandomGUIDUtil {
	/**
	 * 产生唯一的随机字符串
	 * 
	 * @return
	 */
	public static String generateKey() {
		return new RandomGUID(true).toString();
	}
	
	public static void main(String[] args){
		System.out.println(new RandomGUID().valueAfterMD5);
		System.out.println(new RandomGUID(false).toString());
		System.out.println(generateKey());
		try {
			System.out.println(InetAddress.getLocalHost().toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}