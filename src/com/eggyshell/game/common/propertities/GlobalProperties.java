package com.eggyshell.game.common.propertities;

import com.eggyshell.game.server.config.ServerType;

/**
 * 读取global.properties配置
 * @author Pawn
 * @date 2018年8月30日
 */
public class GlobalProperties extends AbstractProperties{
	
	public GlobalProperties(String uri) {
		super(uri);
	}

	public ServerType getServerType() {
		return ServerType.parse(getIntProperty("serverType"));
	}
	
	public int getServerPort() {
		return getIntProperty("serverPort");
	}
	
	public int getSkewingTime() {
		return getIntProperty("skewingTime");
	}
	
}
