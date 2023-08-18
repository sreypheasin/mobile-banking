package co.istad.mobilebanking.api.users;

import co.istad.mobilebanking.api.users.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {

//    TODO: Find all users
    @SelectProvider(type = UserProvider.class, method = "buildSelectAllUsersSql")
    @Results(
            id = "userResult",
            value ={
            @Result(property = "name", column = "name"),
                    @Result(property = "gender", column = "gender"),
                    @Result(property = "isStudent", column = "is_student"),
                    @Result(property = "studentCardId", column = "student_card_id"),
    }
    )
    List <User> select();
//TODO: Find User by Id
    @ResultMap("userResult")
    @SelectProvider(type = UserProvider.class, method = "buildFindUserByIdSql")
    Optional<User> selectUserById (@Param("id") Integer id);

//    TODO: Insert a user
    @InsertProvider(type = UserProvider.class, method = "buildInsertUserSql")
    @Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
    void insertUser(@Param("u")  User user);

//    TODO: Delete user
//    checking is user exist or not

    @Select("SELECT EXISTS(SELECT * FROM users WHERE id = #{id})")
    Boolean isExisted (@Param("id") Integer id);

    @DeleteProvider(type = UserProvider.class, method = "buildDeleteByIdSql")
    void deletedById(@Param("id") Integer id);

//    TODO: Updated status is_deleted
    @UpdateProvider(type = UserProvider.class, method = "buildUpdateIsDeletedSql")
    void updateIsDeleteById(@Param("id") Integer id, @Param("status") boolean status);

//    Update user
    @UpdateProvider(type = UserProvider.class, method = "buildUpdateById")
    @ResultMap("userResult")
    void updateUserById(@Param("u") User user);
}
