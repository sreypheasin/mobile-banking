package co.istad.mobilebanking.api.users;

import co.istad.mobilebanking.api.users.web.CreateUserDto;
import co.istad.mobilebanking.api.users.web.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
//    TODO: Model to Dto
    List <UserDto> modelToDto(List<User> model);

//  TODO: CreateUserDto to User
    User createUserDtoToUser(CreateUserDto createUserDto);
//    TODO: User to UserDto
    UserDto userToUserDto(User user);

//    TODO: UserDto to User
    User userDtoToUser(UserDto userDto);

}