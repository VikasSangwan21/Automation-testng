package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	
	public static Properties property;
	
	public static void initialiseUiProperties() {
		try {
			property = new Properties();
			InputStream instrm = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration/configsettings.properties");
			property.load(instrm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
