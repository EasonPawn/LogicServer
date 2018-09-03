package com.eggyshell.utils;

/**
 * 运行时内存相关工具类
 * @author Pawn
 * @date 2018年9月3日
 */
public class MemoryUtils {
	/**
	 * 获取Java进程可用的最大内存 与-Xmx相对应
	 * 单位为Mb
	 * @return
	 */
	public static int getMaxMemoryByMb() {
		return (int) (Runtime.getRuntime().maxMemory() / 1024 / 1024);
	}
	
	/**
	 * 获取Java进程已使用的所有内存 与-Xms相对应(初始化内存分配，之后会逐渐涨到-Xmx)
	 * 单位为Mb
	 * @return
	 */
	public static int getTotalMemoryByMb() {
		return (int) (Runtime.getRuntime().totalMemory() / 1024 / 1024);
	}
	
	/**
	 * 获取Java进程中TotalMemory中没用使用的内存
	 * 单位Mb
	 * @return
	 */
	public static int getFreeMemoryByMb() {
		return (int) (Runtime.getRuntime().freeMemory() / 1024 / 1024);
	}
	
	/**
	 * 获取Java进程中内存相关信息
	 * @return
	 */
	public static String getMemoryInfo() {
		return "MaxMemoryByMb:" + getFreeMemoryByMb() + " TotalMemoryByMb:" + getTotalMemoryByMb() + " FreeMempryByMb:" + getFreeMemoryByMb();
	}
}
