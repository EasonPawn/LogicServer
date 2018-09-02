package com.eggyshell.game.server.config;

import com.eggyshell.game.common.exception.NoEnumParseException;

public enum ServerType {
	LOGIN(0, "LoginServer"),
	ONLINE(1, "OnlineServer"),
	;
	
	private int id;
	private String desc;

	private ServerType(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public static ServerType parse(int id) {
		for(ServerType serverType : ServerType.values()) {
			if(serverType.id == id) {
				return serverType;
			}
		}
		throw new NoEnumParseException(ServerType.class, id);
	}

	public String getDesc() {
		return desc;
	}
	
}
