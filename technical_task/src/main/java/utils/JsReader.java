package utils;

import java.io.*;
import java.util.logging.Logger;

public class JsReader {
    private static final Logger LOGGER = Logger.getLogger(JsReader.class.getName());
    public static String readFile(String filePath) {
        LOGGER.info("Loading js file");
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }

        return content.toString();
    }
}
