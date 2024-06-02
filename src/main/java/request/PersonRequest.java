package request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequest {

    private String name;
    private int age;
    private String placeOfBirth;
    private String occupation;
}
