package tests.messageBoard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import testInitializers.SignUpUserTestInit;
import utilities.extensions.SignUpBuilderExtension;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

@ExtendWith(SignUpBuilderExtension.class)
public class SignUpUserTests extends SignUpUserTestInit {

    private static final Long RESPONSE_TIMEOUT = 10L;


//Another aproach for the tests, using initializer
//In Order to pass, update TestUsers.USERNAME1 value to not existing username!

    @DisplayName("Should SignUp New User")
    @Test
    public void signUpAndValidateNewUser() {
        signUpNewUserResponse
                .statusCode(SC_OK)
                .body("modelType", is("UserModel"));
    }
}