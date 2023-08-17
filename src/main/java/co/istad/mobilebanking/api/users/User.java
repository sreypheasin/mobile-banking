package co.istad.mobilebanking.api.users;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class User{
    private Integer id;
    private String name;
    private String gender;
    private String oneSignalId;
    private Boolean isDeleted;
    private Boolean isStudent;
    private String StudentCardId;
}



