package co.istad.mobilebanking.api.users.web;


import co.istad.mobilebanking.api.users.UserService;
import co.istad.mobilebanking.base.BaseRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@Slf4j
public class UserRestController {
    private final UserService userService;

//    TODO: Find all users
    @GetMapping
    public BaseRest<?> finaAll(){
        var userDtoList = userService.findAll();
        return BaseRest.builder()
                .status(true)
                .code(200)
                .message("User found")
                .data(userDtoList)
                .build();

    }
//    TODO: create new user
    @PostMapping
    public BaseRest<?> createNewUser(@RequestBody @Valid CreateUserDto createUserDto){
//        log.info("createUserDto: {}",createUserDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.CREATED.value())
                .message("User has been created, successfully!")
                .timestamp(LocalDateTime.now())
                .data(userService.createNewUser(createUserDto))
                .build();
    }
}
