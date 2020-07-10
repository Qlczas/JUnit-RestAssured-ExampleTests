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
}
