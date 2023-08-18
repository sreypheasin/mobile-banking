package co.istad.mobilebanking.api.users;

import co.istad.mobilebanking.api.users.web.CreateUserDto;
import co.istad.mobilebanking.api.users.web.UpdateUserDto;
import co.istad.mobilebanking.api.users.web.UserDto;
import com.github.pagehelper.PageInfo;
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
//    TODO : PageInfoUser To PageInfoUserDto

    PageInfo<UserDto> pageInfoUserTOPageInfoUserDto (PageInfo<User> userPageInfo);
//   TODO: updateUserDto to user
    User updateUserDtoToUser (UpdateUserDto updateUserDto);
}
