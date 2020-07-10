package tests.messageBoard;

import builders.model.post.UserData;
import builders.objects.UserObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testData.endpoints.messageBoard.ResponseValues;

import static builders.objects.UserObject.buildNewUserWithGivenUsername;

import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;
import static org.hamcrest.Matchers.is;
import static testData.endpoints.messageBoard.Endpoints.SIGN_UP;
import static utilities.ApiProperties.API_PROPERTIES;
import static utilities.AuthorizationHandler.authorize;

public class SignUpErrorHandlingTests {

    protected static UserData newUserNoUsernameData = buildNewUserWithGivenUsername("");
    protected static UserData newUserTooLongUsernameData = buildNewUserWithGivenUsername("TestNameThatIsTooLong!");
    protected static UserData newUserTooShortUsernameData = buildNewUserWithGivenUsername("T");
    protected static UserData newUserDigitsOnlyUsernameData = buildNewUserWithGivenUsername("12345");
    protected static UserData newUserNoPasswordData = UserObject.buildNewUserWithGivenPassword("");

    @BeforeAll
    static void setup() {
        System.out.println("Current API under test: "+API_PROPERTIES.getMessageBoardBaseUrl());
    }

    @DisplayName("Should Not SignUp New User with Empty Username")
    @Test
    public void noSignUpUserWithMissingName() {
        authorize().log().all()
                .body(newUserNoUsernameData)
                .when().post(API_PROPERTIES.getMessageBoardBaseUrl()+SIGN_UP)
                .then().log().all()
                .statusCode(SC_UNPROCESSABLE_ENTITY)
                .body("message", is(ResponseValues.USERNAME_INCORRECT_LENGTH));
    }

    @DisplayName("Should Not SignUp New User with Too Long Username")
    @Test
    public void noSignUpUserWithTooLongName() {
        authorize().log().all()
                .body(newUserTooLongUsernameData)
                .when().post(API_PROPERTIES.getMessageBoardBaseUrl()+SIGN_UP)
                .then().log().all()
                .statusCode(SC_UNPROCESSABLE_ENTITY)
                .body("message", is(ResponseValues.USERNAME_INCORRECT_LENGTH));
    }

    @DisplayName("Should Not SignUp New User with Too Short Username")
    @Test
    public void noSignUpUserWithTooShortName() {
        authorize().log().all()
                .body(newUserTooShortUsernameData)
                .when().post(API_PROPERTIES.getMessageBoardBaseUrl()+SIGN_UP)
                .then().log().all()
                .statusCode(SC_UNPROCESSABLE_ENTITY)
                .body("message", is(ResponseValues.USERNAME_INCORRECT_LENGTH));
    }

    @DisplayName("Should Not SignUp New User with Digits Only Username")
    @Test
    public void noSignUpUserWithDigitsOnlyName() {
        authorize().log().all()
                .body(newUserDigitsOnlyUsernameData)
                .when().post(API_PROPERTIES.getMessageBoardBaseUrl()+SIGN_UP)
                .then().log().all()
                .statusCode(SC_UNPROCESSABLE_ENTITY)
                .body("message", is(ResponseValues.USERNAME_INCORRECT_DIGITS));
    }

    //TODO Notify DevTeam about defect in response message, should be "Password" with uppercase
    @DisplayName("Should Not SignUp New User with Empty Password")
    @Test
    public void noSignUpUserWithNoPassword() {
        authorize().log().all()
                .body(newUserNoPasswordData)
                .when().post(API_PROPERTIES.getMessageBoardBaseUrl()+SIGN_UP)
                .then().log().all()
                .statusCode(SC_UNPROCESSABLE_ENTITY)
                .body("message", is(ResponseValues.PASSWORD_INCORRECT_LENGTH));
    }
    
    //TODO Verify in above manner the firstname, lastname and password fields
}