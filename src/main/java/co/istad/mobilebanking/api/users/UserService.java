package co.istad.mobilebanking.api.users;

import co.istad.mobilebanking.api.users.web.CreateUserDto;
import co.istad.mobilebanking.api.users.web.UserDto;

import java.util.List;

public interface UserService {

//    TODO: Find all users
    List<UserDto> findAll();

//    TODO: create new user
    UserDto createNewUser(CreateUserDto createUserDto);

}
