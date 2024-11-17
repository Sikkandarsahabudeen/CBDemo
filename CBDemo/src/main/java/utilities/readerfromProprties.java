package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readerfromProprties {

    public static void populateSettings() {
        readerfromProprties readers = new readerfromProprties();
        try {
            readers.reader();
        } catch (IOException e) {
            System.err.println("Failed to populate settings: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void reader() throws IOException {
        Properties properties = new Properties();
        String filePath = System.getProperty("user.dir") +"/src/main/java/utilities/GlobalConfig.Properties";


        System.out.println("Attempting to load properties file from: " + filePath);
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
            System.out.println("Properties file loaded successfully.");

            String browser = properties.getProperty("Browser");
            if (browser == null) {
                System.err.println("Browser property not found in properties file.");
            } else {
                System.out.println("Browser property found: " + browser);
                settings.browser = browser;  // Ensure 'settings' is properly defined
            }
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
            throw e;  // Rethrow exception after logging
        }
        settings.US= properties.getProperty("US");
        settings.UK= properties.getProperty("UK");
        settings.CA= properties.getProperty("CA");
        settings.AU= properties.getProperty("AU");
        settings.HK= properties.getProperty("HK");
        settings.ZA= properties.getProperty("ZA");

    }
}
