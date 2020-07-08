package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utilities.ApiProperties.API_PROPERTIES;

public enum CredentialsProperties {

    CREDENTIALS;

    private static final String CREDENTIALS_PROPERTIES_PATH = "src/test/resources/credentials.properties";
    private Properties properties = new Properties();

    CredentialsProperties() {
        try {
            properties.load(new FileInputStream(CREDENTIALS_PROPERTIES_PATH));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public String sso() {
        return properties.getProperty("sso");
    }

    public String fullName() {
        return properties.getProperty("fullName");
    }

    public String getAccessToken() {
        return API_PROPERTIES.env().equalsIgnoreCase("dev") ? devAccessToken() : stageAccessToken();
    }

    public String proxyHost() {
        return properties.getProperty("proxyHost");
    }

    public int proxyPort() {
        return Integer.parseInt(properties.getProperty("proxyPort"));
    }

    private String devAccessToken() {
        return properties.getProperty("devAccessToken");
    }

    private String stageAccessToken() {
        return properties.getProperty("stageAccessToken");
    }
}
