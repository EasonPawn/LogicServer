package com.eggyshell.game.server.jetty;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

/**
 * Jetty PlainText转Json
 * @author Pawn
 * @date 2018年9月2日
 */
public abstract class AbstractJettyJsonHandler extends AbstractJettyPlainTextHandler{

	@Override
	protected String execute(String plainText, HttpServletRequest httpServletRequest) {
		JSONObject jsonObject = JSONObject.parseObject(plainText);
		if(jsonObject == null) {
			jsonObject = new JSONObject();
		}
		while(httpServletRequest.getParameterNames().hasMoreElements()) {
			String elementName = httpServletRequest.getParameterNames().nextElement();
			jsonObject.put(elementName, httpServletRequest.getAttribute(elementName));
		}
		return handle(jsonObject).toJSONString();
	}
	
	protected abstract JSONObject handle(JSONObject input);

}
