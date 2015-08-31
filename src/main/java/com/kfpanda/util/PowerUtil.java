package com.kfpanda.util;

import java.math.BigInteger;

/**
 * 2的幂运算工具类。
 * @author awifi-core
 * @date 2015年1月7日 下午8:18:59
 */
public class PowerUtil {
	/**
	 * 说明:检查一个数是否是2的指定次幂的值 如16 ,4
	 * @param totalPurview 16
	 * @param optPurview  4
	 * @return
	 */
	public static boolean checkPower(int totalPurview, int optPurview) {
		long purviewValue = (long) Math.pow(2, optPurview);
		return (totalPurview & purviewValue) == purviewValue;
	}

	/**
	 * 说明 16 再加上2的4次方等于多少
	 * @param totalPurview
	 * @param optPurview
	 * @return
	 */
	public static int addPower(int totalPurview, int optPurview) {
		return totalPurview | (int) Math.pow(2, optPurview);
	}

	/**
	 * 说明: 1000  & ~0001=> 1000 & 1110 => 1000 1001 & ~0001= 1000
	 * @param totalPurview
	 * @param optPurview
	 * @return
	 */
	public static int removePower(int totalPurview, int optPurview) {
		return totalPurview & ~(int) Math.pow(2, optPurview);
	}
	
	/**
	 * 说明:同checkPower int 版本
	 * @param totalPurview
	 * @param optPurview
	 * @return boolean
	 */
	public static boolean checkPower(long totalPurview, int optPurview) {
		long purviewValue = (long) Math.pow(2, optPurview);
		return (totalPurview & purviewValue) == purviewValue;
	}

	/**
	 *  说明:1000 | 0001 => 1001 
	 * @param totalPurview
	 * @param optPurview
	 * @return long
	 */
	public static long addPower(long totalPurview, int optPurview) {
		return totalPurview | (long) Math.pow(2, optPurview);
	}

	/**
	 * 说明:说明: 1000  & ~0001=> 1000 & 1110 => 1000 1001 & ~0001= 1000
	 * @param totalPurview
	 * @param optPurview
	 * @return long
	 */
	public static long removePower(long totalPurview, int optPurview) {
		return totalPurview & ~(long) Math.pow(2, optPurview);
	}

	/**
	 * 说明:说明:检查一个数是否是2的指定次幂的值 如16 ,4
	 * @param totalPurview
	 * @param optPurview
	 * @return boolean
	 */
	public static boolean checkPower(BigInteger totalPurview, int optPurview) {
		BigInteger purviewValue = getPurviewValue(optPurview);
		return totalPurview.and(purviewValue).compareTo(purviewValue) == 0;
	}

	/**
	 * 说明:1000 | 0001 => 1001 
	 * @param totalPurview
	 * @param optPurview
	 * @return BigInteger
	 */
	public static BigInteger addPower(BigInteger totalPurview, int optPurview) {
		BigInteger purviewValue = getPurviewValue(optPurview);
		return totalPurview.or(purviewValue);
	}

	/**
	 * 说明:说明: 1000  & ~0001=> 1000 & 1110 => 1000 1001 & ~0001= 1000
	 * @param totalPurview
	 * @param optPurview
	 * @return BigInteger
	 */
	public static BigInteger removePower(BigInteger totalPurview, int optPurview) {
		BigInteger purviewValue = getPurviewValue(optPurview);
		return totalPurview.andNot(purviewValue);
	}
	
	/**
	 * 说明:得到2的指定幂值
	 * @param optPurview
	 * @return BigInteger
	 */
	private static BigInteger getPurviewValue(int optPurview){
		return BigInteger.valueOf(2).pow(optPurview);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// purview =2^2+2^3+2^4＝28
		for (int i = 0; i <= 5; i++) {
			System.out.println("checkPower(28, "+i+")" + checkPower(28, i));
			System.out.println(addPower(28, i));
			System.out.println(removePower(28, i));
		}
		
//		System.out.println("BigInteger test...");
//		BigInteger totalPurview = BigInteger.valueOf(28);
//		for (int i = 0; i <= 5; i++) {
//			System.out.println("totalPurview="+totalPurview+"optPurview="+i+": " + checkPower(totalPurview, i));
//			System.out.println(addPower(totalPurview, i));
//			System.out.println(removePower(totalPurview, i));
//		}
	}
}
