package com.eggyshell.game.server;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggyshell.game.common.propertities.CommonPropertiesManager;
import com.eggyshell.game.common.propertities.GlobalProperties;
import com.eggyshell.game.server.config.ServerType;
import com.eggyshell.game.server.jetty.JettyServer;
import com.eggyshell.utils.MemoryUtils;
import com.eggyshell.utils.PathUtils;

/**
 * 服务启动入口
 * @author Pawn
 *
 */
public class NetServer {
	
	private static Logger logger = LoggerFactory.getLogger(NetServer.class);
	
	public static void main(String[] args) {
		try {
			PropertyConfigurator.configure(PathUtils.getRealResourcePath("/res/log/log4j.properties"));
			logger.error("=========================Server Start===========================");
			CommonPropertiesManager.getInstance().loadProperties();
			GlobalProperties globalProperties = CommonPropertiesManager.getInstance().getGlobalProperties();
			logger.error("加载服务器类型:" + globalProperties.getServerType().getDesc());
			if(globalProperties.getServerType() == ServerType.LOGIN) {
				JettyServer jettyServer = new JettyServer(globalProperties.getServerPort());
				jettyServer.start();
				logger.error("Start jetty server success, listened port is {}", globalProperties.getServerPort());
			}
			logger.error(MemoryUtils.getMemoryInfo());
			logger.error("=======================Server Start End==========================");
		} catch (Exception e) {
			logger.error("Server Start Error!");
			System.exit(1);
		}
		
	}
}
