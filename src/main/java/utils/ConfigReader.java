package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

//    public static void LoadConfig() {
//        try {
//            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
//            properties = new Properties();
//            properties.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static String Get(String key) {
        return properties.getProperty(key);
    }

	public static void LoadConfig() {
		// TODO Auto-generated method stub
		try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
