package builders.objects;

import builders.model.post.UserData;
import testData.endpoints.messageBoard.TestData;

public class UserObject {

    public static UserData buildNewUser() {
        System.out.println("# Building New User Credentials");
        return UserData.builder()
                .username(TestData.USERNAME_RANDOM)
                .password(TestData.PASSWORD1)
                .firstname(TestData.FIRST_NAME1)
                .lastname(TestData.LAST_NAME1)
                .build();
    }

    public static UserData buildNewUserWithGivenUsername(String username) {
        return UserData.builder()
                .username(username)
                .password(TestData.PASSWORD1)
                .firstname(TestData.FIRST_NAME1)
                .lastname(TestData.LAST_NAME1)
                .build();
    }

    public static UserData buildNewUserWithGivenPassword(String password) {
        return UserData.builder()
                .username(TestData.USERNAME_RANDOM)
                .password(password)
                .firstname(TestData.FIRST_NAME1)
                .lastname(TestData.LAST_NAME1)
                .build();
    }
}
