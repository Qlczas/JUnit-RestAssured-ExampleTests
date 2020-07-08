package utilities.extensions;

import io.restassured.RestAssured;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import static utilities.ApiProperties.API_PROPERTIES;

@ExtendWith(TestConfigurationExtension.class)
public class SignUpBuilderExtension implements BeforeAllCallback {

    public void beforeAll(ExtensionContext extensionContext) {
        RestAssured.baseURI = API_PROPERTIES.getMessageBoardBaseUrl();
    }
}
