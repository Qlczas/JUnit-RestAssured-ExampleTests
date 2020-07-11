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

public class ThreadMessagingTests {

    protected static ThreadData newThreadData = buildNewPrivateThread();

    @DisplayName("Should post a new Message")
    @Test
    public void shouldPostMessageInThread() {
        String threadId = authorize(TestData.USERNAME1,TestData.PASSWORD1).log().all()
                .body(newThreadData)
                .when().post(API_PROPERTIES.getMessageBoardBaseUrl()+THREADS)
                .then().log().all()
                .statusCode(SC_OK)
                .body("modelType", is(ResponseValues.MODELTYPE_THREAD_MODEL))
                .extract().path("id");
        System.out.println("# Created Thread ID is: " + threadId);

        authorize(TestData.USERNAME1,TestData.PASSWORD1).log().all()
                .when().post(API_PROPERTIES.getMessageBoardBaseUrl()
                +MESSAGE_START+threadId+MESSAGE_END)
                .then().log().all()
                .statusCode(SC_OK)
                .body("modelType", is(ResponseValues.MODELTYPE_THREAD_MODEL));
    }
}