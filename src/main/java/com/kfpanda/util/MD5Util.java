package com.kfpanda.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/**
 * MD5工具类
 * @author awifi-core
 * @date 2015年1月7日 下午7:55:32
 */
public class MD5Util {
	
	/**
	 * md5加密 
	 * @param s 待加密字符串
	 * @return
	 */
	public  static String MD5(String s) {
		if (StringUtils.isEmpty(s) || StringUtils.isBlank(s))
		{
			return null;
		}
		
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 对对象流处理后MD5加密
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public static String getHashCode(Object object) throws IOException{
		if(object == null) return "";
		
		String ss = null;
		ObjectOutputStream s = null;
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
			try {
				s = new ObjectOutputStream(bo);
				s.writeObject(object);
				s.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(s != null) {
					s.close();
					s = null;
				}
			}
		ss = MD5(bo.toString());
		//System.out.println(bo.toString());
		return ss;
	}
	
	public static void main(String[] args) throws IOException {
		String str = "serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)";
		//System.out.println(MD5(str));
		ThreadUtils.sleep(5000);
		//System.out.println(StringTokenizerUtils.split("1,3:3", ",;")[0]);
	}
}
