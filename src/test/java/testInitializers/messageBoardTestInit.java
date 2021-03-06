package testInitializers;

import builders.model.post.UserData;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import requestSpecifications.messageBoard.SignUpNewUserRequest;

import static builders.objects.UserObject.buildNewUser;

public class messageBoardTestInit {

    protected static UserData newUserData = buildNewUser();
    protected static ValidatableResponse signUpNewUserResponse;

    @Step("Prepare test data")
    @BeforeAll
    public static void init() {
        System.out.println("# Current API under test: "+ RestAssured.baseURI);

        signUpNewUserResponse = SignUpNewUserRequest.signUpNewUser(newUserData);

    }
}
