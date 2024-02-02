package utils;

import enums.PropertyVariable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesUtils {
    private static final Logger LOGGER = Logger.getLogger(PropertiesUtils.class.getName());
    private PropertiesUtils() {
    }

    public static String loadProperties(String path, PropertyVariable variable) {
        LOGGER.info("Loading files from properties files");
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);

        }
        return properties.getProperty(String.valueOf(variable).toUpperCase());
    }
}
