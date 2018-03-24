package com.wbl.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigUtils {
 
	    public static final Properties prop = new Properties();
	    static Logger log= LogManager.getLogger(ConfigUtils.class);
	
	public ConfigUtils(String fileName){
		
		try{
			prop.load(new FileInputStream(fileName));
			
		}catch(IOException e)
		{
			//e.printStackTrace();
			log.error(e.getMessage());
		}
		
		
	}
	public String getProperty( String key){
		return prop.getProperty(key);
	}
}
