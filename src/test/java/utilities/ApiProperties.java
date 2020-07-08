package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum ApiProperties {

    API_PROPERTIES;

    private static final String API_PROPERTIES_PATH = "src/test/resources/api.properties";
    private Properties properties = new Properties();

    ApiProperties() {
        try {
            properties.load(new FileInputStream(API_PROPERTIES_PATH));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public String env() {
        return properties.getProperty("env");
    }

    public String getMessageBoardBaseUrl() {
        return properties.getProperty("messageBoardBaseUrl");
    }

    public String signupUser() {
        return properties.getProperty("signupAPI");
    }
}