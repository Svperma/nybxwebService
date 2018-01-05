package com.dsib.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;
	
	public ConfigManager() {
		String configFile = "database.properties";
		properties = new Properties();
		InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public static ConfigManager getInstance() {
		if(null == configManager) 
			configManager = new ConfigManager();
		return configManager;
	}
}
