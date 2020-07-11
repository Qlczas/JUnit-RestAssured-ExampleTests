package builders.objects;

import builders.model.post.ThreadData;
import testData.endpoints.messageBoard.TestData;

public class ThreadObject {

    public static ThreadData buildNewPrivateThread() {
        System.out.println("# Building New Private Thread");
        return ThreadData.builder()
                .name(TestData.THREAD_RANDOM)
                .isPrivate(true)
                .build();
    }

    public static ThreadData buildThreadWithGivenName(String threadName) {
        System.out.println("# Building New Public Thread with name: " + threadName);
        return ThreadData.builder()
                .name(threadName)
                .isPrivate(false)
                .build();
    }
}
