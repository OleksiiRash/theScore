package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties getProperties(String path) {

        FileInputStream fis = null;
        Properties properties = null;

        try {
            fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return properties;
    }

    public static String getProperty(String key) {

        Properties properties = null;

        try {
            properties = getProperties(Constants.CONFIG_READER_PATH);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(key);
    }

}
