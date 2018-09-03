package com.eggyshell.game.server.jetty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jetty参数为文本格式请求处理
 * @author Pawn
 * @date 2018年9月2日
 */
public abstract class AbstractJettyPlainTextHandler{

	private static Logger logger = LoggerFactory.getLogger(AbstractHandler.class);
	
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream(), Charset.forName("utf-8")));
		String line;
		while((line = bufferedReader.readLine()) != null) {
			sb.append(line);
		}
		bufferedReader.close();
		logger.info("JettyServer获取到的请求内容:{}", sb.toString());
		String response = execute(sb.toString(), httpServletRequest);
		logger.info("JettyServer处理后的响应内容:{}", response);
		Writer writer = httpServletResponse.getWriter();
		writer.append(response);
		writer.flush();
		writer.close();
	}

	protected abstract String execute(String plainText, HttpServletRequest httpServletRequest);
	
}
