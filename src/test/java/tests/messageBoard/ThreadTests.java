package tests.messageBoard;

import builders.model.post.ThreadData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testData.endpoints.messageBoard.ResponseValues;
import testData.endpoints.messageBoard.TestData;

import static builders.objects.ThreadObject.buildNewPrivateThread;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static testData.endpoints.messageBoard.Endpoints.*;
import static utilities.ApiProperties.API_PROPERTIES;
import static utilities.AuthorizationHandler.authorize;

public class ThreadTests {

    protected static ThreadData newThreadData = buildNewPrivateThread();

    @DisplayName("Should validate user for Threads Exist")
    @Test
    public void shouldValidateUser() {
        authorize().log().all()
                .queryParam("username", TestData.USERNAME1)
                .when().get(API_PROPERTIES.getMessageBoardBaseUrl()+VALIDATE_USER)
                .then().log().all()
                .statusCode(SC_OK)
                .body("modelType", is(ResponseValues.MODELTYPE_USERNAME_VALIDATION));
    }

    @DisplayName("Should post a new Thread")
    @Test
    public void shouldPostThread() {
        authorize(TestData.USERNAME1,TestData.PASSWORD1).log().all()
                .body(newThreadData)
                .when().post(API_PROPERTIES.getMessageBoardBaseUrl()+THREADS)
                .then().log().all()
                .statusCode(SC_OK)
                .body("modelType", is(ResponseValues.MODELTYPE_THREAD_MODEL));
    }

    //TODO Test Thread name already taken
}