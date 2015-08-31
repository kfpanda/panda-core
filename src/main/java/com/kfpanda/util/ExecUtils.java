package com.kfpanda.util;

import java.io.File;

/**
 * 执行cmd控制台指令
 * @author awifi-core
 * @date 2015年1月7日 下午7:00:11
 */
public class ExecUtils {
	public static boolean isWindows() {
		String os = System.getProperty("os.name").toLowerCase();
		// windows
		return (os.indexOf("win") >= 0);
	}

	/**
	 * 说明:判断当前系统是否是mac
	 * @return boolean
	 */
	public static boolean isMac() {
		String os = System.getProperty("os.name").toLowerCase();
		// Mac
		return (os.indexOf("mac") >= 0);
	}

	/**
	 * 说明:判断当前系统是否是unix系统
	 * @return boolean
	 */
	public static boolean isUnix() {
		String os = System.getProperty("os.name").toLowerCase();
		// linux or unix
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
	}

	/**
	 * 说明:判断当前操作系统
	 * @return boolean
	 */
	public static boolean isSolaris() {
		String os = System.getProperty("os.name").toLowerCase();
		// Solaris
		return (os.indexOf("sunos") >= 0);
	}

	/**
	 * 执行指令
	 * @param cmd 指令字符串
	 * @return
	 */
	public static boolean execCmd(String cmd) {

		if (isUnix()) {
//			cmd = "/bin/sh -c " + cmd;
		} else {
			cmd = "cmd /c start " + cmd;
		}

		return exec(cmd);
	}

	/**
	 * 说明:执行终端命令
	 * @param cmd
	 * @return boolean 是否成功
	 */
	private static boolean exec(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 拼接可执行指令并调用执行方法
	 * @param srcPdfPath 源文件
	 * @param destDirPath 目标文件
	 * @return 
	 */
	public static boolean pdf2json(String srcPdfPath, String destDirPath){
		File srcPdf = new File(srcPdfPath);
		File destDir = new File(destDirPath);
		if (!srcPdf.exists()) return false;
		if (!destDir.exists()) destDir.mkdirs();
		
		boolean isUnix = isUnix();
		StringBuilder sbCmd = new StringBuilder(
				isUnix ? "pdf2json.sh" : "pdf2json.bat");
		sbCmd.append(" ").append(isUnix ? "pdf2json" : "pdf2json.exe")
				.append(" ").append(srcPdfPath)
				.append(" ").append(destDirPath);
		
		System.out.println(sbCmd);
		return execCmd(sbCmd.toString());

	}
	public static void main(String[] args) {
		StringBuilder sbCmd = new StringBuilder(
				"D:/Program/mupdf/win32/test/pdf2json.bat");
		sbCmd.append(" ").append("D:/Program/mupdf/win32/test/pdf2json.exe")
				.append(" ").append("D:/Program/mupdf/win32/test/v.pdf")
				.append(" ").append("D:/Program/mupdf/win32/test/a");
		System.out.println("test " + execCmd(sbCmd.toString()));

		// try {
		// Runtime.getRuntime().exec("cmd /c start "+sbCmd.toString());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}
}
