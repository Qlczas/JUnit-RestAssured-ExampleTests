package builders.model.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ThreadData {

    @JsonProperty(value = "name")
    private final String name;

    @JsonProperty(value = "private")
    private final Boolean isPrivate;

}
