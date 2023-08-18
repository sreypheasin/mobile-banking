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

//   Find all users
    @GetMapping
    public BaseRest<?> finaAll(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "limit", required = false, defaultValue = "20") int limit
//           @RequestParam(name = "name", required = false, defaultValue = "") String name
    ){
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been found!")
                .timestamp(LocalDateTime.now())
                .data(userService.findAll(page,limit))
                .build();
    }
//    Find user by id
    @GetMapping("/{id}")
    public BaseRest<?> findUserById(@PathVariable Integer id){
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User not found!")
                .timestamp(LocalDateTime.now())
                .data(userService.findUserById(id))
                .build();
    }

//    pagination

//   create new user
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

//   Delete user by id
    @DeleteMapping("/{id}")
    public BaseRest<?> deleteUserById(@PathVariable Integer id){
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted successfully...!")
                .timestamp(LocalDateTime.now())
                .data(userService.deleteUserById(id))
                .build();
    }

//   Update is_deleted status
    @PutMapping("/{id}")
    public BaseRest<?> updateIsDeletedStatus(@PathVariable  Integer id, @RequestBody IsDeletedDto dto){

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Updated successfully...!")
                .timestamp(LocalDateTime.now())
                .data(userService.updateIsDeletedStatus(id, dto.status()))
                .build();
    }
}
