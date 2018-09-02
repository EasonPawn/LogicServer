package com.eggyshell.game.common.propertities;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggyshell.utils.PathUtils;

/**
 * 读取properties配置文件基类
 * @author Pawn
 * @date 2018年8月30日
 */
public abstract class AbstractProperties {
	
	static Logger logger = LoggerFactory.getLogger(AbstractProperties.class);
	
	private Properties properties;
	private String uri;
	
	protected AbstractProperties(String uri) {
		properties = new Properties();
		this.uri = uri;
	}
	
	public void load() {
		try {
			properties.load(PathUtils.getResourceInputStream(uri));
			logger.info("加载配置文件{}", uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取配置中key对应的String属性值
	 * @param key
	 * @return
	 */
	protected String getStringProterty(String key) {
		return properties.getProperty(key);
	}
	
	/**
	 * 获取配置中key对应的Integer属性值
	 * @param key
	 * @return
	 */
	protected int getIntProperty(String key) {
		return Integer.parseInt(getStringProterty(key));
	}
	
	/**
	 * 获取配置中key对应的Float属性值
	 * @param key
	 * @return
	 */
	protected float getFloatProperty(String key) {
		return Float.parseFloat(getStringProterty(key));
	}
}
