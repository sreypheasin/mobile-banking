package co.istad.mobilebanking.api.users;

import co.istad.mobilebanking.api.users.web.CreateUserDto;
import co.istad.mobilebanking.api.users.web.UserDto;

import java.util.List;

public interface UserService {

//    TODO: Find
    List<UserDto> findAll();
    UserDto findUserById (Integer id);

//    TODO: create new user
    UserDto createNewUser(CreateUserDto createUserDto);

//    TODO: delete user by id
    Integer deleteUserById(Integer id);
//    TODO: updated isDeleted status
    Integer updateIsDeletedStatus(Integer id,boolean status);

}
