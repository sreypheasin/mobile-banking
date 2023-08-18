package co.istad.mobilebanking.api.users.web;

import lombok.Builder;

@Builder
public record UpdateUserDto(String name, String gender) {
}
