package co.istad.mobilebanking.api.users.web;

import lombok.Builder;

@Builder
public record UserDto (
        String name,
        String gender,
        Boolean isStudent,
        String studentCardId
){
}
