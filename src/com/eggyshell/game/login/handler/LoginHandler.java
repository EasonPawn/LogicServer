package com.eggyshell.game.login.handler;

import com.alibaba.fastjson.JSONObject;
import com.eggyshell.game.server.jetty.AbstractJettyJsonHandler;

/**
 * 短连接登录协议
 * @author Pawn
 * @date 2018年9月3日
 */
public class LoginHandler extends AbstractJettyJsonHandler{

	@Override
	protected JSONObject handle(JSONObject input) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("isSuccess", "ok");
		return jsonObject;
	}
	
}
