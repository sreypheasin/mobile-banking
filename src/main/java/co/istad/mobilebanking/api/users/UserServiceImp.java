package co.istad.mobilebanking.api.users;

import co.istad.mobilebanking.api.users.web.CreateUserDto;
import co.istad.mobilebanking.api.users.web.UpdateUserDto;
import co.istad.mobilebanking.api.users.web.UserDto;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService{
    private final UserMapStruct userMapStruct;
    private final UserMapper userMapper;

//    TODO: Find
//    Find all user
    @Override
    public PageInfo<UserDto> findAll(int page, int limit) {
        PageInfo <User> userPageInfo = PageHelper.startPage( page ,limit).doSelectPageInfo(userMapper::select);
        return userMapStruct.pageInfoUserTOPageInfoUserDto(userPageInfo);
    }

//    Find user by id
    @Override
    public UserDto findUserById(Integer id) {
        User user= userMapper.selectUserById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with id %d is not found",id)));
        return userMapStruct.userToUserDto(user);
    }

    //    TODO: Create new user
    @Override
    public UserDto createNewUser(CreateUserDto createUserDto) {
        User user = userMapStruct.createUserDtoToUser(createUserDto);
        userMapper.insertUser(user);
//        log.info("User id = {}", user.getId());
        return this.findUserById(user.getId());
    }

//    TODO: Delete user by id
    @Override
    public Integer deleteUserById(Integer id) {
        boolean isFound = userMapper.isExisted(id);
        if(isFound){
            userMapper.deletedById(id);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d, not found!",id));
    }

    //    TODO: Update status is_deleted
    @Override
    public Integer updateIsDeletedStatus(Integer id,boolean status) {

        boolean isFound = userMapper.isExisted(id);
        if(isFound){
            userMapper.updateIsDeleteById(id,status);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d, not found!",id));
    }

//    Update user
    @Override
    public UserDto updateUserById(Integer id, UpdateUserDto updateUserDto) {
        if(userMapper.isExisted(id)){
            User user = userMapStruct.updateUserDtoToUser(updateUserDto);
            user.setId(id);
            userMapper.updateUserById(user);
            return this.findUserById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d, not found!",id));
    }
}
