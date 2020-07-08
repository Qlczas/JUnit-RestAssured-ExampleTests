package tests.messageBoard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static utilities.ApiProperties.API_PROPERTIES;

public class BasicTests {

    @BeforeAll
    static void setup() {
        System.out.println("Current API under test: "+API_PROPERTIES.getMessageBoardBaseUrl());
    }

    @DisplayName("Service should be up and return Code 200: OK")
    @Test
    public void shouldReturnOkCode() {
        given()
                .when().get(API_PROPERTIES.getMessageBoardBaseUrl())
                .then().statusCode(SC_OK)
                        .body("api", is("test workshop api"));
    }
}