package co.istad.mobilebanking.exception;

import co.istad.mobilebanking.base.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApiException {

//    Exception for Search User by id
    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseError<?> handleServerException(ResponseStatusException e){
        return BaseError.builder()
                .status(false)
                .code(e.getStatusCode().value())
                .message("Something when wrong...! Please check.")
                .timestamp(LocalDateTime.now())
                .error(e.getReason())
                .build();
    }

//    Exception for Insert User
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseError<?> handleValidationException(MethodArgumentNotValidException e){
        List<Map<String,String>> errors = new ArrayList<>();

        for(FieldError error : e.getFieldErrors()){
            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("name", error.getField());
            errorDetails.put("message",error.getDefaultMessage());
            errors.add(errorDetails);
        }
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Validation Error, Please check details message...!")
                .timestamp(LocalDateTime.now())
                .error(errors)
                .build();
    }
}
