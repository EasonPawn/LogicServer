package com.eggyshell.game.server.jetty;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JettyHandlerAdapter extends AbstractHandler{
	
	Logger logger = LoggerFactory.getLogger(JettyHandlerAdapter.class);
	
	private Map<String, AbstractJettyPlainTextHandler> jettyPlainTextMap;
	
	public JettyHandlerAdapter() {
		jettyPlainTextMap = new HashMap<>();
	}

	@Override
	public void handle(String uri, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
		logger.info("Jetty请求路径:{}", uri);
		//去除uri最前面的'/'
		String handlerKey = uri.substring(1);
		//处理浏览器发起的对图标文件的请求
		if(handlerKey.equals("favicon.ico")) {
			return;
		}
		//区分请求类型
		String requestMethod = httpServletRequest.getMethod();
		if(requestMethod.equals("POST")) {
			//获取对应的Handler
			AbstractJettyPlainTextHandler handler = jettyPlainTextMap.get(handlerKey);
			if(handler != null) {
				handler.handle(httpServletRequest, httpServletResponse);
			}else {
				logger.error("Jetty请求没有找到对应的路径{}!", handlerKey);
				return;
			}
		}else {
			logger.error("请求类型不符合要求:{}", requestMethod);
			return;
		}
	}
	
	public void addJettyPlainTextHandler(String handlerKey, AbstractJettyPlainTextHandler handler) {
		jettyPlainTextMap.put(handlerKey, handler);
	}

}
