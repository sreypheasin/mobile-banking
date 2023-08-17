package co.istad.mobilebanking.api.users.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CreateUserDto(
        @NotBlank(message = "Name is require!")
        String name,
        @NotBlank(message = "gender is require!")
        String gender,
        String oneSignalId,

        @NotNull(message = "You have to confirm, Is you a student or not?")
        Boolean isStudent,
        String studentCardId
) {
}
