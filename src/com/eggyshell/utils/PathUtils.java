package com.eggyshell.utils;

import java.io.InputStream;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;

/**
 * 路径相关的操作工具类
 * @author Pawn
 * @date 2018/08/29
 */
public class PathUtils {
	/**
	 * 获取项目bin目录路径
	 * @return
	 */
	public static String getBinPath() {
		return PathUtils.class.getResource("/").getPath();
	}
	
	/**
	 * 获取项目root目录路径
	 * @return
	 */
	public static String getRootPath() {
		return System.getProperty("user.dir");
	}
	
	/**
	 * 获取bin下的类路径
	 * @param class1
	 * @return
	 */
	public static String getBinClassPath(Class<?> class1) {
		return class1.getResource("").getPath();
	}
	
	/**
	 * 获取项目下的类路径
	 * @param class1
	 * @return
	 */
	public static String getRealClassPath(Class<?> class1) {
		return getBinClassPath(class1).replace("/bin", "");
	}
	
	/**
	 * 获取bin下资源的路径
	 * @param res
	 * @return
	 */
	public static String getBinResourcePath(String res){
		if(StringUtils.isNotEmpty(res)) {
			if(res.startsWith("//")) {
				res = res.substring(1);
			}
			if(!res.startsWith("/")) {
				res = "/" + res;
			}
			URL uri = PathUtils.class.getResource(res);
			if(uri != null) {
				return uri.getPath();
			}
		}
		return getRootPath() + res;
	}
	
	/**
	 * 获取项目目录下的资源路径
	 * @param res
	 * @return
	 */
	public static String getRealResourcePath(String res) {
		if(StringUtils.isNotEmpty(res)) {
			if(res.startsWith("//")) {
				res = res.substring(1);
			}
			if(!res.startsWith("/")) {
				res = "/" + res;
			}
			URL uri = PathUtils.class.getResource(res);
			if(uri != null) {
				return uri.getPath().replace("/bin", "");
			}
		}
		return getRootPath() + res;
	}
	
	/**
	 * 获取资源文件的流文件
	 * @param res
	 * @return
	 */
	public static InputStream getResourceInputStream(String res){
		if(StringUtils.isNotEmpty(res)) {
			if(res.startsWith("//")) {
				res = res.substring(1);
			}
			if(!res.startsWith("/")) {
				res = "/" + res;
			}
		}else{
			res = "";
		}
		return PathUtils.class.getResourceAsStream(res);
	}
	
	public static void main(String[] args) {
		System.out.println(getBinPath());
		System.out.println(getRootPath());
		System.out.println(getRealClassPath(PathUtils.class));
		System.out.println(getBinResourcePath("//game/ServerType.Properties"));
	}
}
