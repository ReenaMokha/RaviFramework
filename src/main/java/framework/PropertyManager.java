package framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
	
	public static Properties prop = null;
	
	public static String getProperty(String key){
		try {
		String value = System.getProperty(key);
		if(prop==null){
			prop = new Properties();
			 InputStream file = ClassLoader.getSystemClassLoader().getResourceAsStream("automation.properties");
		
				prop.load(file);
		}
		if(value==null){
			value = prop.getProperty(key);
		}
		return value;
		} catch(Exception ex){}
		
		
		return null;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
