package com.eggyshell.game.server;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggyshell.game.common.propertities.CommonPropertiesManager;
import com.eggyshell.utils.PathUtils;

/**
 * 服务启动入口
 * @author Pawn
 *
 */
public class NetServer {
	
	private static Logger logger = LoggerFactory.getLogger(NetServer.class);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure(PathUtils.getRealResourcePath("/res/log/log4j.properties"));
		logger.error("==========================项目开始启动===========================");
		CommonPropertiesManager.getInstance().loadProperties();
		logger.error("加载服务器类型:" + CommonPropertiesManager.getInstance().getGlobalProperties().getServerType().getDesc());
		
	}
	
}
