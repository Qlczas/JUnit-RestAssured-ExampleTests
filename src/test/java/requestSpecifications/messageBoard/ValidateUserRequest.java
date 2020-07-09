package requestSpecifications.messageBoard;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static testData.endpoints.messageBoard.Endpoints.VALIDATE_USER;
import static utilities.AuthorizationHandler.authorize;

public class ValidateUserRequest {

    @Step("GET /validate/username")
    public static ValidatableResponse validateUserResponse(String username) {
        System.out.println("# TEST ENDPOINT: "+VALIDATE_USER);
        return authorize().log().all()
                .when()
                .post(VALIDATE_USER+username)
                .then().log().all();
    }
}