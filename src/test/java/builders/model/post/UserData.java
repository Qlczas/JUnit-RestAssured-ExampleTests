package builders.model.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserData {

    @JsonProperty(value = "username")
    private final String username;

    @JsonProperty(value = "password")
    private final String password;

    @JsonProperty(value = "firstname")
    private final String firstname;

    @JsonProperty(value = "lastname")
    private final String lastname;
}
