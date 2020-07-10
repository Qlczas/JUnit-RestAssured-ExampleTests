package utilities;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static utilities.CredentialsProperties.CREDENTIALS;

public class AuthorizationHandler {

    @Step("Authorise")
    public static RequestSpecification authorize() {
        return given()
                .spec(setAuthCredentials());
    }

    @Step("Authorise With Given Credentials")
    public static RequestSpecification authorize(String username, String password) {
        return given()
                .auth()
                .basic(username, password)
                .contentType(ContentType.JSON);
    }

    private static RequestSpecification setAuthCredentials() {
        System.out.println("# Building Request type: JSON");
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + CREDENTIALS.getAccessToken())
                .build();
    }
}
