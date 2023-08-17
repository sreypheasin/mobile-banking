package co.istad.mobilebanking.api.users;

import co.istad.mobilebanking.api.users.web.CreateUserDto;
import co.istad.mobilebanking.api.users.web.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService{
    private final UserMapStruct userMapStruct;
    private final UserMapper userMapper;

//    TODO: Find all users
    @Override
    public List<UserDto> findAll() {
        List <User> users = userMapper.selectAllUsers();
//        log.info("users: {}",users);
        return userMapStruct.modelToDto(users);
    }

//    TODO: Create new user
    @Override
    public UserDto createNewUser(CreateUserDto createUserDto) {
        User user = userMapStruct.createUserDtoToUser(createUserDto);
        userMapper.insertUser(user);
//        log.info("User id = {}", user.getId());
        return userMapStruct.userToUserDto(user);
    }


}
