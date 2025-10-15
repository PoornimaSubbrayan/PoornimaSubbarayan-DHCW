package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private Properties properties;

    public PropertyReader(String filePath) {
        properties = new Properties();

        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException exception) {
            System.out.println("Error while reading the properties file" + exception.getMessage());
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
