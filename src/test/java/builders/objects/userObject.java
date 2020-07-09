package builders.objects;

import builders.model.post.UserData;
import testData.endpoints.messageBoard.TestUsers;

public class userObject {

    public static UserData buildNewUser() {
        System.out.println("# Building New User Credentials");
        return UserData.builder()
                .username(TestUsers.USERNAME1)
                .password(TestUsers.PASSWORD1)
                .firstname(TestUsers.FIRST_NAME1)
                .lastname(TestUsers.LAST_NAME1)
                .build();
    }
}
