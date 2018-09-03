package com.eggyshell.game.server.jetty;

import org.eclipse.jetty.server.Server;

import com.eggyshell.game.login.handler.LoginHandler;

/**
 * JettyServer
 * @author Pawn
 * @date 2018年9月2日
 */
public class JettyServer {
	
	private Server server;
	private JettyHandlerAdapter jettyHandlerAdapter;
	
	public JettyServer(int port) {
		initJettyHandlerAdapter();
		server = new Server(port);
		server.setHandler(jettyHandlerAdapter);
	}
	
	private void initJettyHandlerAdapter() {
		jettyHandlerAdapter = new JettyHandlerAdapter();
		jettyHandlerAdapter.addJettyPlainTextHandler("loginHandler", new LoginHandler());
	}
	
	public void start() {
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		try {
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
