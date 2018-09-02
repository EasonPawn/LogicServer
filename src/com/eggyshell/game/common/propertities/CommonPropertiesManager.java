package com.eggyshell.game.common.propertities;

public class CommonPropertiesManager {

	private static CommonPropertiesManager propertiesManager = new CommonPropertiesManager();
	
	private GlobalProperties globalProperties;

	private CommonPropertiesManager() {
		globalProperties = new GlobalProperties("/properties/global.properties");
	}
	
	public static CommonPropertiesManager getInstance() {
		return propertiesManager;
	}
	
	public void loadProperties() {
		globalProperties.load();
	}

	public GlobalProperties getGlobalProperties() {
		return globalProperties;
	}

}
