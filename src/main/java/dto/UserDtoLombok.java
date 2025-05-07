package dto;

import lombok.*;


@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserDtoLombok {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

}
