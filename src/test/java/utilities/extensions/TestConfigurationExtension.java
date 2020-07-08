package utilities.extensions;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.restassured.mapper.ObjectMapperType.GSON;

public class TestConfigurationExtension implements BeforeAllCallback {

    public void beforeAll(ExtensionContext extensionContext) {
        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(new ObjectMapperConfig(GSON))
                .logConfig(new LogConfig().enableLoggingOfRequestAndResponseIfValidationFails());
    }
}
