package builders.objects;

import builders.model.post.UserData;

public class userObject {

    public static UserData buildNewUser() {
        System.out.println("# Building New User Credentials");
        return UserData.builder()
                .username("Tester")
                .password("Admin1")
                .firstname("Testy")
                .lastname("Testowitz")
                .build();
    }
}
