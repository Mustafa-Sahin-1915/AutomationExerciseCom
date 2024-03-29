package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //This class reads the configuration.properties file
    //Create Properties instance
    private static Properties properties;
    static {
        //path of the configuration file

        String path = "configuration.properties";
        try {
            //Opening configuration.properties file using FileInputStream
            FileInputStream fileInputStream  = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //This method will get the key from properties file,
    //And return the value as String
    //We create this method to read the file
    public static String getProperty(String key){
        String value = properties.getProperty(key);
        return value;
    }
}
