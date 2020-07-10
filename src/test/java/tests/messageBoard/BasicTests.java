package tests.messageBoard;

import builders.model.post.UserData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testData.endpoints.messageBoard.TestUsers;

import static builders.objects.UserObject.buildNewUser;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static testData.endpoints.messageBoard.Endpoints.SIGN_UP;
import static testData.endpoints.messageBoard.Endpoints.VALIDATE_USER;
import static utilities.ApiProperties.API_PROPERTIES;
import static utilities.AuthorizationHandler.authorize;

public class BasicTests {

    protected static UserData newUserData = buildNewUser();

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

    @DisplayName("Should sign up new User")
    @Test
    public void signUpNewUser() {
        authorize().log().all()
                .body(newUserData)
                .when().post(API_PROPERTIES.getMessageBoardBaseUrl()+SIGN_UP)
                .then().log().all()
                .statusCode(SC_OK)
                .body("modelType", is("UserModel"));
    }

    @DisplayName("Should validate signed up User")
    @Test
    public void validateUser() {
        authorize().log().all()
                .queryParam("username", TestUsers.USERNAME1)
                .when().get(API_PROPERTIES.getMessageBoardBaseUrl()+VALIDATE_USER)
                .then().log().all()
                .statusCode(SC_OK)
                .body("modelType", is("UsernameValidationModel"));
    }
}