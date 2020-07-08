package requestSpecifications.messageBoard;

import builders.model.post.UserData;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static testData.endpoints.messageBoard.Endpoints.SIGN_UP;
import static utilities.AuthorizationHandler.authorize;

public class SignUpNewUserRequest {

    @Step("POST /SignUp")
    public static ValidatableResponse signUpNewUser(UserData requestBody) {
        System.out.println("# TEST ENDPOINT: "+SIGN_UP);
        return authorize().log().all()
                .body(requestBody)
                .relaxedHTTPSValidation()
              //  .proxy(CREDENTIALS.proxyHost(), CREDENTIALS.proxyPort())
                .when()
                .post(SIGN_UP)
                .then().log().all();
    }
}