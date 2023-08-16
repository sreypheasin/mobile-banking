package co.istad.mobilebanking.base;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
// Builder is similar to and @AllArgsConstructor, it's just not required to pass all the arguments
public record BaseRest<T>(
        Boolean status,
        Integer code,
        String message,
        LocalDateTime timestamp,
        T data

) {
}
