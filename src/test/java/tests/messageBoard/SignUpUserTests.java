package tests.messageBoard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import testInitializers.messageBoardTestInit;
import utilities.extensions.SignUpBuilderExtension;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

@ExtendWith(SignUpBuilderExtension.class)
public class SignUpUserTests extends messageBoardTestInit {

    private static final Long RESPONSE_TIMEOUT = 10L;

    @DisplayName("Should SignUp New User")
    @Test
    public void shouldSignUpNewUser() {
        signUpNewUserResponse
                .statusCode(SC_OK)
                .body("modelType", is("UserModel"));
    }
}